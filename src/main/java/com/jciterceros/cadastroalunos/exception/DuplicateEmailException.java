package com.jciterceros.cadastroalunos.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super(String.format("Email já cadastrado: %s", email));
    }
}