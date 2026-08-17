# Spring AI Multi-Provider Client

A Spring Boot reference project that exposes a consistent `ChatClient` workflow across DeepSeek and Zhipu AI. It demonstrates provider-specific model wiring while keeping the calling code independent from SDK details.

## Highlights

- Two model providers behind Spring AI's unified `ChatClient` API
- Explicit bean qualification for deterministic provider selection
- Interactive command-line workflow for quick model comparison
- Credentials loaded exclusively from environment variables
- Spring AI BOM-based dependency alignment

## Architecture

```text
User input
   └── Provider selector
         ├── deepSeekChatClient → DeepSeekChatModel
         └── zhipuChatClient    → ZhiPuAiChatModel
```

## Run locally

Requirements: JDK 17+ and Maven 3.9+.

```bash
export DEEPSEEK_API_KEY='your-deepseek-key'
export ZHIPU_API_KEY='your-zhipu-key'
cd DeepSeekApi_Client_Demo
./mvnw spring-boot:run
```

Choose a provider in the terminal, enter a prompt, and the selected `ChatClient` will return the response.

## Key files

- `ChatClientConfig.java`: provider-specific `ChatClient` beans
- `ChatClientExample.java`: interactive routing and invocation
- `application.yml`: environment-based provider configuration

## Security

No credentials are committed to this repository. Use environment variables or a dedicated secret manager in deployed environments, and rotate any credential that has ever appeared in source control.

## Tech stack

- Java 17
- Spring Boot 3.5
- Spring AI 1.1
- DeepSeek and Zhipu AI model starters
