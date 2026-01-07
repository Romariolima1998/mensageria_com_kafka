package com.example.sender_email.config;

import com.example.sender_email.business.EmailService;
import com.example.sender_email.business.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class EmailConsumerConfig {

    private final EmailService emailService;

    @Bean
    public Consumer<MessageDTO> processarEmail(){
        return dto -> {
            try {
                log.info(" \n Recebido: {}", dto.getRemetente() + "\n");
                emailService.enviaEmail(dto);
            } catch (Exception e) {
                log.error("Erro ao processar mensagem do Kafka: {}", e.getMessage());
                // Ao não lançar a exceção para fora, o Spring entende que
                // a mensagem foi "processada" (mesmo com erro) e não tenta de novo.
            }
        };
    }
}
