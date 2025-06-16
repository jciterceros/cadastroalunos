package com.jciterceros.cadastroalunos.controller;

import com.jciterceros.cadastroalunos.dto.EventoDTO;
import com.jciterceros.cadastroalunos.dto.EventoResponseDTO;
import com.jciterceros.cadastroalunos.model.Evento;
import com.jciterceros.cadastroalunos.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public ResponseEntity<EventoResponseDTO> create(@Valid @RequestBody EventoDTO dto) {
        Evento evento = service.cadastrarEvento(dto);
        return ResponseEntity.ok(EventoResponseDTO.fromEntity(evento));
    }

    @GetMapping
    public ResponseEntity<Page<EventoResponseDTO>> list(Pageable pageable) {
        Page<Evento> eventos = service.listarEventos(pageable);
        return ResponseEntity.ok(eventos.map(EventoResponseDTO::fromEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> getById(@PathVariable Long id) {
        Evento evento = service.buscarPorId(id);
        return ResponseEntity.ok(EventoResponseDTO.fromEntity(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EventoDTO dto) {
        Evento evento = service.atualizarEvento(id, dto);
        return ResponseEntity.ok(EventoResponseDTO.fromEntity(evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/periodo/{periodoLetivoId}")
    public ResponseEntity<Page<EventoResponseDTO>> buscarPorPeriodoLetivo(
            @PathVariable Long periodoLetivoId,
            Pageable pageable) {
        Page<Evento> eventos = service.buscarPorPeriodoLetivo(periodoLetivoId, pageable);
        return ResponseEntity.ok(eventos.map(EventoResponseDTO::fromEntity));
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<Page<EventoResponseDTO>> buscarPorProfessor(
            @PathVariable Long professorId,
            Pageable pageable) {
        Page<Evento> eventos = service.buscarPorProfessor(professorId, pageable);
        return ResponseEntity.ok(eventos.map(EventoResponseDTO::fromEntity));
    }
}