package com.jciterceros.cadastroalunos.exception;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(Long id) {
        super(String.format("Aluno não encontrado com o ID: %d", id));
    }
}