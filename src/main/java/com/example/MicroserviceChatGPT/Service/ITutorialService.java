package com.example.MicroserviceChatGPT.Service;

import com.example.MicroserviceChatGPT.Model.Tutorial;

import java.util.List;

public interface ITutorialService {

    List<Tutorial> tutorials(String topic, int total);
}
