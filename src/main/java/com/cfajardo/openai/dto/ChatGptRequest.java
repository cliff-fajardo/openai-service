package com.cfajardo.openai.dto;

import java.util.ArrayList;
import java.util.List;

public class ChatGptRequest {

    private String model;
    private List<Message> messages;

    public ChatGptRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();

        Message msg = new Message();
        msg.setRole("user");
        msg.setContent(prompt);
        this.messages.add(msg);
    }
}
