package com.jciterceros.cadastroalunos.dto;

import com.jciterceros.cadastroalunos.model.Evento.TipoEvento;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventoDTO {
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 3, max = 100, message = "Título deve ter entre 3 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 10, max = 500, message = "Descrição deve ter entre 10 e 500 caracteres")
    private String descricao;

    @NotNull(message = "Data de início é obrigatória")
    private LocalDateTime dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    private LocalDateTime dataFim;

    @NotNull(message = "Tipo do evento é obrigatório")
    private TipoEvento tipo;

    @NotNull(message = "ID do período letivo é obrigatório")
    private Long periodoLetivoId;

    @NotNull(message = "ID do professor é obrigatório")
    private Long professorId;
}