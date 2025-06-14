package com.jciterceros.cadastroalunos.exception;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(Long id) {
        super("Aluno não encontrado com ID: " + id);
    }
}