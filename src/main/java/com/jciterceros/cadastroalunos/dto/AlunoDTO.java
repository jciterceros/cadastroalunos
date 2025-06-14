package com.jciterceros.cadastroalunos.dto;

import com.jciterceros.cadastroalunos.model.Aluno.StatusMatricula;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AlunoDTO {
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Matrícula é obrigatória")
    @Pattern(regexp = "^\\d{7}$", message = "Matrícula deve conter 7 dígitos")
    private String matricula;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser uma data passada")
    private LocalDate dataNascimento;

    @Pattern(regexp = "^\\(\\d{2}\\) \\d{5}-\\d{4}$", message = "Telefone deve estar no formato (99) 99999-9999")
    private String telefone;

    @Size(max = 200, message = "Endereço deve ter no máximo 200 caracteres")
    private String endereco;

    @NotBlank(message = "Curso é obrigatório")
    private String curso;

    @NotNull(message = "Período é obrigatório")
    @Min(value = 1, message = "Período deve ser maior que 0")
    @Max(value = 10, message = "Período deve ser menor ou igual a 10")
    private Integer periodo;

    @NotNull(message = "Status da matrícula é obrigatório")
    private StatusMatricula statusMatricula;
}