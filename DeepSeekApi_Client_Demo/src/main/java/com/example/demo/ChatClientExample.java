package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.Scanner;

@Configuration
public class ChatClientExample {

    @Bean
    @ConditionalOnProperty(name = "app.cli.enabled", havingValue = "true", matchIfMissing = true)
    CommandLineRunner cli(
            @Qualifier("zhipuChatClient") ChatClient zhipuChatClient,
            @Qualifier("deepSeekChatClient") ChatClient deepSeekChatClient) {

        return args -> {
            var scanner = new Scanner(System.in);
            ChatClient chat;

            // Model selection
            System.out.println("\nSelect your AI model:");
            System.out.println("1. ZhipuChatClient");
            System.out.println("2. DeepSeekChatClient");
            System.out.print("Enter your choice (1 or 2): ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                chat = zhipuChatClient;
                System.out.println("Using ZHIPU model");
            } else {
                chat = deepSeekChatClient;
                System.out.println("Using DEEPSeek model");
            }

            // Use the selected chat client
            System.out.print("\nEnter your question: ");
            String input = scanner.nextLine();
            String content = chat.prompt(input).call().content();
            System.out.println("ASSISTANT: " + content);

            scanner.close();
        };
    }
}
