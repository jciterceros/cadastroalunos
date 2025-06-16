package com.jciterceros.cadastroalunos.dto;

import com.jciterceros.cadastroalunos.model.Evento;
import com.jciterceros.cadastroalunos.model.Evento.TipoEvento;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventoResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private TipoEvento tipo;

    // Dados simplificados do período letivo
    private Long periodoLetivoId;
    private String periodoLetivoNome;

    // Dados simplificados do professor
    private Long professorId;
    private String professorNome;
    private String professorEmail;
    private String professorAreaAtuacao;

    public static EventoResponseDTO fromEntity(Evento evento) {
        EventoResponseDTO dto = new EventoResponseDTO();
        dto.setId(evento.getId());
        dto.setTitulo(evento.getTitulo());
        dto.setDescricao(evento.getDescricao());
        dto.setDataInicio(evento.getDataInicio());
        dto.setDataFim(evento.getDataFim());
        dto.setTipo(evento.getTipo());
        dto.setPeriodoLetivoId(evento.getPeriodoLetivo().getId());
        dto.setPeriodoLetivoNome(evento.getPeriodoLetivo().getNome());
        dto.setProfessorId(evento.getProfessor().getId());
        dto.setProfessorNome(evento.getProfessor().getNome());
        return dto;
    }
}