package com.jciterceros.cadastroalunos.dto;

import com.jciterceros.cadastroalunos.model.Aluno.StatusMatricula;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AlunoDTO {
    private String nome;
    private String matricula;
    private String email;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    private String curso;
    private Integer periodo;
    private StatusMatricula statusMatricula;
}