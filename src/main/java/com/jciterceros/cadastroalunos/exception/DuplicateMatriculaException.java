package com.jciterceros.cadastroalunos.exception;

public class DuplicateMatriculaException extends RuntimeException {
    public DuplicateMatriculaException(String matricula) {
        super("Matrícula já cadastrada: " + matricula);
    }
}