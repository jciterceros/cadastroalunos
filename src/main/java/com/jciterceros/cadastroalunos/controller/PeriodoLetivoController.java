package com.jciterceros.cadastroalunos.controller;

import com.jciterceros.cadastroalunos.dto.PeriodoLetivoDTO;
import com.jciterceros.cadastroalunos.model.PeriodoLetivo;
import com.jciterceros.cadastroalunos.service.PeriodoLetivoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/periodos-letivos")
public class PeriodoLetivoController {

    @Autowired
    private PeriodoLetivoService service;

    @PostMapping
    public ResponseEntity<PeriodoLetivo> create(@Valid @RequestBody PeriodoLetivoDTO dto) {
        PeriodoLetivo periodo = service.cadastrarPeriodoLetivo(dto);
        return ResponseEntity.ok(periodo);
    }

    @GetMapping
    public ResponseEntity<Page<PeriodoLetivo>> list(Pageable pageable) {
        Page<PeriodoLetivo> periodos = service.listarPeriodosLetivos(pageable);
        return ResponseEntity.ok(periodos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoLetivo> getById(@PathVariable Long id) {
        PeriodoLetivo periodo = service.buscarPorId(id);
        return ResponseEntity.ok(periodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoLetivo> update(@PathVariable Long id, @Valid @RequestBody PeriodoLetivoDTO dto) {
        PeriodoLetivo periodo = service.atualizarPeriodoLetivo(id, dto);
        return ResponseEntity.ok(periodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletarPeriodoLetivo(id);
        return ResponseEntity.noContent().build();
    }
}