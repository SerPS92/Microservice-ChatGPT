package com.example.MicroserviceChatGPT.Controller;

import com.example.MicroserviceChatGPT.Model.Tutorial;
import com.example.MicroserviceChatGPT.Service.ITutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TutorialController {

    private final ITutorialService tutorialService;

    public TutorialController(ITutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping(value = "tutorials", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tutorial>> tutorials(@RequestParam(name = "topic") String topic,
                                                    @RequestParam(name = "total") int total){
        return new ResponseEntity<>(tutorialService.tutorials(topic, total), HttpStatus.OK);
    }
}
