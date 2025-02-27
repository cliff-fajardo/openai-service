package com.cfajardo.openai.controller;

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

    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;


    @PostMapping("/chat")
    @ResponseBody
    public String chat(@RequestBody String prompt) throws ExecutionException, InterruptedException {

        OpenAIClient client = OpenAIOkHttpClient.builder().apiKey(openaiApiKey).build();

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage(prompt)
                .model(ChatModel.GPT_4O_MINI)
                .build();

        CompletableFuture<ChatCompletion> chatCompletion = client.async().chat().completions().create(params);
        ChatCompletion result = chatCompletion.join();
        return result.choices().get(0).message().content().get();
    }
}
