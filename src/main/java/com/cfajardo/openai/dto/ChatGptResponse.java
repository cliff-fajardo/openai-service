package com.cfajardo.openai.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import com.openai.models.ChatCompletion.Choice;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptResponse {

    private List<Choice> choices = new ArrayList<>();

}
