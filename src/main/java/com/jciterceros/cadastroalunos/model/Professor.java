package com.jciterceros.cadastroalunos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String email;

    @Column(name = "area_atuacao")
    private String areaAtuacao;

    @Column(name = "titulacao")
    private String titulacao;

    @OneToMany(mappedBy = "professor")
    private List<Evento> eventos;
}