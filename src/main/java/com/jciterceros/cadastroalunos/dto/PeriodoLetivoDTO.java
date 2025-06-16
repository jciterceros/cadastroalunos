package com.jciterceros.cadastroalunos.dto;

import com.jciterceros.cadastroalunos.model.PeriodoLetivo.StatusPeriodo;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PeriodoLetivoDTO {
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotNull(message = "Data de início é obrigatória")
    private LocalDate dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    private LocalDate dataFim;

    @NotNull(message = "Ano é obrigatório")
    @Min(value = 2000, message = "Ano deve ser maior ou igual a 2000")
    @Max(value = 2100, message = "Ano deve ser menor ou igual a 2100")
    private Integer ano;

    @NotNull(message = "Semestre é obrigatório")
    @Min(value = 1, message = "Semestre deve ser 1 ou 2")
    @Max(value = 2, message = "Semestre deve ser 1 ou 2")
    private Integer semestre;

    @NotNull(message = "Status é obrigatório")
    private StatusPeriodo status;
}