package com.jciterceros.cadastroalunos.exception;

public class ProfessorNotFoundException extends RuntimeException {
    public ProfessorNotFoundException(Long id) {
        super(String.format("Professor não encontrado com o ID: %d", id));
    }
}