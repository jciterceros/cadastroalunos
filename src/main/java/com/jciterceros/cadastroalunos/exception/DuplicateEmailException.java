package com.jciterceros.cadastroalunos.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
<<<<<<< HEAD
        super("Email já cadastrado: " + email);
=======
        super(String.format("Email já cadastrado: %s", email));
>>>>>>> 4c1e74c4df2294716ac5f8ef13bd75567ceddf16
    }
}