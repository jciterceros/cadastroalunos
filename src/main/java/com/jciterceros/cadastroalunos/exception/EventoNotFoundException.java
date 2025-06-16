package com.jciterceros.cadastroalunos.exception;

public class EventoNotFoundException extends RuntimeException {
    public EventoNotFoundException(Long id) {
        super(String.format("Evento não encontrado com o ID: %d", id));
    }
}