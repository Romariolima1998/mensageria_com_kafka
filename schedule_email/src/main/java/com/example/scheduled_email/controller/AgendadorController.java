package com.example.scheduled_email.controller;

import com.example.scheduled_email.business.AgendadorService;
import com.example.scheduled_email.business.dto.MessageDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("mensagem")
@Tag(name="agendador de email")
public class AgendadorController {

    private final AgendadorService service;

    @PostMapping
    public ResponseEntity<String> agendar(@RequestBody MessageDTO dto){
        log.info("\n iniciando agendamento na thread: " + Thread.currentThread() + "\n");
        service.agendar(dto);
        log.info("fim do agendamento");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("email agendado");
    }
}
