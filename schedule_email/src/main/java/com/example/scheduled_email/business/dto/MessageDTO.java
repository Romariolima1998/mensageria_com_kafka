package com.example.scheduled_email.business.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    @NotBlank(message = "o remetente e obrigatorio")
    private String remetente;

    @NotBlank(message = "O destinatário é obrigatório")
    @Email(message = "O formato do e-mail é inválido")
    private String destinatario;

    @NotBlank(message = "O assunto não pode estar vazio")
    @Size(min = 5, max = 100, message = "O assunto deve ter entre 5 e 100 caracteres")
    private String assunto;

    @NotBlank(message = "O corpo do e-mail é obrigatório")
    private String corpo;
}
