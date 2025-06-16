package com.jciterceros.cadastroalunos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDateTime dataFim;

    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

    @ManyToOne
    @JoinColumn(name = "periodo_letivo_id")
    private PeriodoLetivo periodoLetivo;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public enum TipoEvento {
        AVALIACAO,
        REUNIAO,
        PALESTRA,
        TRABALHO_PRATICO,
        OUTRO
    }
}