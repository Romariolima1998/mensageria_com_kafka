package com.example.scheduled_email.business;

import com.example.scheduled_email.business.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AgendadorService {
    private final StreamBridge streamBridge;

    @Async
    public void agendar(MessageDTO dto){
        streamBridge.send("enviarEmail-out-0", dto);
        log.info("\n  agendado na thread: " + Thread.currentThread() + "\n");
    }
}
