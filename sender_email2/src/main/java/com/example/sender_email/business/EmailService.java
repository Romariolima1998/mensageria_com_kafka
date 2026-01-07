package com.example.sender_email.business;

import com.example.sender_email.business.dto.MessageDTO;

import com.example.sender_email.business.exceptions.EmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Value("${envio.email.remetente}")
    public String remetente;


    @Async
    public void enviaEmail(MessageDTO dto){
        try{
            MimeMessage mensagem = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    mensagem, true, StandardCharsets.UTF_8.name()
            );
            mimeMessageHelper.setFrom(new InternetAddress(remetente, dto.getRemetente()));
            mimeMessageHelper.setTo(InternetAddress.parse(dto.getDestinatario()));
            mimeMessageHelper.setSubject(dto.getAssunto());

            Context context = new Context();
            context.setVariable("mensagem", dto.getCorpo());

            String content = templateEngine.process("notificacao", context);
            mimeMessageHelper.setText(content,true);
            javaMailSender.send(mensagem);
            log.info(" \n mensagem enviada \n");

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailException("Erro ao enviar email", e.getCause());
        }
    }

}
