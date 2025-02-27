package com.cfajardo.openai.services;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    public String chat(String message){
        OpenAIClient client = OpenAIOkHttpClient.builder().apiKey(openaiApiKey).build();

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage(message)
                .model(ChatModel.GPT_4O_MINI)
                .build();

        CompletableFuture<ChatCompletion> chatCompletion = client.async().chat().completions().create(params);
        ChatCompletion result = chatCompletion.join();
        return result.choices().get(0).message().content().get();
    }
}
