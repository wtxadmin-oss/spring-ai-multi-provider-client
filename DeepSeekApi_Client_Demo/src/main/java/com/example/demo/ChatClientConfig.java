package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient ZhipuChatClient(ZhiPuAiChatModel chatModel) {
        return ChatClient.create(chatModel);
    }
    @Bean
    public ChatClient DeepSeekChatClient(DeepSeekChatModel chatModel) {
        return ChatClient.create(chatModel);
    }
}