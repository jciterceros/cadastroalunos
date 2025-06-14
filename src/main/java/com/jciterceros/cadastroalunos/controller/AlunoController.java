package com.jciterceros.cadastroalunos.controller;

import com.jciterceros.cadastroalunos.dto.AlunoDTO;
import com.jciterceros.cadastroalunos.model.Aluno;
import com.jciterceros.cadastroalunos.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoDTO dto) {
        Aluno aluno = alunoService.cadastrarAluno(dto);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping
    public ResponseEntity<Page<Aluno>> list(Pageable pageable) {
        Page<Aluno> alunos = alunoService.listarAlunos(pageable);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarAlunoPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @Valid @RequestBody AlunoDTO dto) {
        Aluno aluno = alunoService.atualizarAluno(id, dto);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}