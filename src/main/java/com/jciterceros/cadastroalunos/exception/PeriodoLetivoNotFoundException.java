package com.jciterceros.cadastroalunos.exception;

public class PeriodoLetivoNotFoundException extends RuntimeException {
    public PeriodoLetivoNotFoundException(Long id) {
        super(String.format("Período letivo não encontrado com o ID: %d", id));
    }
}