package com.example.MicroserviceChatGPT.Service;

import com.example.MicroserviceChatGPT.Model.Tutorial;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ITutorialServiceImpl implements ITutorialService{

    private final ChatClient chatClient;

    String prompt = """
            Quiero que me muestres una lista con los {total} primeros sitios Web, en orden de importancia, que incluyan tutoriales sobre {topic}.\s
            El resultado me lo mostrarás en una lista JSON, donde cada objeto incluye los siguientes campos: "url"(direccion del sitio),\s
            "descripcion"(breve descripción del sitio Web) y "valoracion"(imagina que eres un experto en la materia y dame tu valoración del sitio entre 1, que significa mal tutorial,  y 5, que sería un muy buen tutorial)
            """;

    public ITutorialServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public List<Tutorial> tutorials(String topic, int total) {
        BeanOutputParser<Tutorial[]> parser = new BeanOutputParser<>(Tutorial[].class);
        PromptTemplate template = new PromptTemplate(prompt);
        template.add("topic", topic);
        template.add("total", total);
        ChatResponse response = chatClient.call(template.create());
        return Arrays.asList(parser.parse(response.getResult().getOutput().getContent()));
    }


}
