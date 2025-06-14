package com.jciterceros.cadastroalunos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "curso")
    private String curso;

    @Column(name = "periodo")
    private Integer periodo;

    @Column(name = "status_matricula")
    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula;

    public enum StatusMatricula {
        ATIVO,
        INATIVO,
        TRANCADO,
        FORMADO
    }
}