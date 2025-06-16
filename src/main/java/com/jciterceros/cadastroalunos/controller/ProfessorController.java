package com.jciterceros.cadastroalunos.controller;

import com.jciterceros.cadastroalunos.dto.ProfessorDTO;
import com.jciterceros.cadastroalunos.dto.ProfessorResponseDTO;
import com.jciterceros.cadastroalunos.model.Professor;
import com.jciterceros.cadastroalunos.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> create(@Valid @RequestBody ProfessorDTO dto) {
        Professor professor = service.cadastrarProfessor(dto);
        return ResponseEntity.ok(ProfessorResponseDTO.fromEntity(professor));
    }

    @GetMapping
    public ResponseEntity<Page<ProfessorResponseDTO>> list(Pageable pageable) {
        Page<Professor> professores = service.listarProfessores(pageable);
        return ResponseEntity.ok(professores.map(ProfessorResponseDTO::fromEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> getById(@PathVariable Long id) {
        Professor professor = service.buscarPorId(id);
        return ResponseEntity.ok(ProfessorResponseDTO.fromEntity(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ProfessorDTO dto) {
        Professor professor = service.atualizarProfessor(id, dto);
        return ResponseEntity.ok(ProfessorResponseDTO.fromEntity(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }
}