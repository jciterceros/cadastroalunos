package com.jciterceros.cadastroalunos.exception;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(Long id) {
<<<<<<< HEAD
        super("Aluno não encontrado com ID: " + id);
=======
        super(String.format("Aluno não encontrado com o ID: %d", id));
>>>>>>> 4c1e74c4df2294716ac5f8ef13bd75567ceddf16
    }
}