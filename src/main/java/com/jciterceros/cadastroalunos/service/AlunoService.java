package com.jciterceros.cadastroalunos.service;

import com.jciterceros.cadastroalunos.dto.AlunoDTO;
import com.jciterceros.cadastroalunos.model.Aluno;
import com.jciterceros.cadastroalunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno cadastrarAluno(AlunoDTO dto) {
        if (alunoRepository.existsByMatricula(dto.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada");
        }
        if (alunoRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setEmail(dto.getEmail());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setTelefone(dto.getTelefone());
        aluno.setEndereco(dto.getEndereco());
        aluno.setCurso(dto.getCurso());
        aluno.setPeriodo(dto.getPeriodo());
        aluno.setStatusMatricula(dto.getStatusMatricula());

        return alunoRepository.save(aluno);
    }

    public Page<Aluno> listarAlunos(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @Transactional
    public Aluno atualizarAluno(Long id, AlunoDTO dto) {
        Aluno aluno = buscarAlunoPorId(id);

        // Verifica se a nova matrícula já existe (se foi alterada)
        if (!aluno.getMatricula().equals(dto.getMatricula()) &&
                alunoRepository.existsByMatricula(dto.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada");
        }

        // Verifica se o novo email já existe (se foi alterado)
        if (!aluno.getEmail().equals(dto.getEmail()) &&
                alunoRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setEmail(dto.getEmail());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setTelefone(dto.getTelefone());
        aluno.setEndereco(dto.getEndereco());
        aluno.setCurso(dto.getCurso());
        aluno.setPeriodo(dto.getPeriodo());
        aluno.setStatusMatricula(dto.getStatusMatricula());

        return alunoRepository.save(aluno);
    }

    @Transactional
    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}