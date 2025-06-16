package com.jciterceros.cadastroalunos.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProfessorDTO {
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Matrícula é obrigatória")
    @Pattern(regexp = "^\\d{7}$", message = "Matrícula deve conter 7 dígitos")
    private String matricula;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Área de atuação é obrigatória")
    private String areaAtuacao;

    @NotBlank(message = "Titulação é obrigatória")
    private String titulacao;
}