package com.jciterceros.cadastroalunos.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("Email já cadastrado: " + email);
    }
}