package com.jciterceros.cadastroalunos.exception;

public class DuplicateMatriculaException extends RuntimeException {
    public DuplicateMatriculaException(String matricula) {
        super(String.format("Matrícula já cadastrada: %s", matricula));
    }
}