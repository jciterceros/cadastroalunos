package com.jciterceros.cadastroalunos.exception;

public class DuplicateMatriculaException extends RuntimeException {
    public DuplicateMatriculaException(String matricula) {
<<<<<<< HEAD
        super("Matrícula já cadastrada: " + matricula);
=======
        super(String.format("Matrícula já cadastrada: %s", matricula));
>>>>>>> 4c1e74c4df2294716ac5f8ef13bd75567ceddf16
    }
}