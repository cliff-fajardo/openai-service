package com.cfajardo.openai.controller;

import com.cfajardo.openai.services.OpenAIService;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/bot")
public class ChatController {

    private final OpenAIService openAIService;

    public ChatController(OpenAIService openAIService){
        this.openAIService = openAIService;
    }

    @PostMapping("/chat")
    @ResponseBody
    public String chat(@RequestBody String prompt) throws ExecutionException, InterruptedException {

        return openAIService.chat(prompt);

    }
}
