package com.jciterceros.cadastroalunos.service;

import com.jciterceros.cadastroalunos.dto.ProfessorDTO;
import com.jciterceros.cadastroalunos.exception.DuplicateEmailException;
import com.jciterceros.cadastroalunos.exception.DuplicateMatriculaException;
import com.jciterceros.cadastroalunos.exception.ProfessorNotFoundException;
import com.jciterceros.cadastroalunos.model.Professor;
import com.jciterceros.cadastroalunos.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Transactional
    public Professor cadastrarProfessor(ProfessorDTO dto) {
        if (repository.existsByMatricula(dto.getMatricula())) {
            throw new DuplicateMatriculaException(dto.getMatricula());
        }
        if (repository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEmailException(dto.getEmail());
        }

        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setMatricula(dto.getMatricula());
        professor.setEmail(dto.getEmail());
        professor.setAreaAtuacao(dto.getAreaAtuacao());
        professor.setTitulacao(dto.getTitulacao());

        return repository.save(professor);
    }

    public Page<Professor> listarProfessores(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Professor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProfessorNotFoundException(id));
    }

    @Transactional
    public Professor atualizarProfessor(Long id, ProfessorDTO dto) {
        Professor professor = buscarPorId(id);

        if (!professor.getMatricula().equals(dto.getMatricula()) &&
                repository.existsByMatricula(dto.getMatricula())) {
            throw new DuplicateMatriculaException(dto.getMatricula());
        }

        if (!professor.getEmail().equals(dto.getEmail()) &&
                repository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEmailException(dto.getEmail());
        }

        professor.setNome(dto.getNome());
        professor.setMatricula(dto.getMatricula());
        professor.setEmail(dto.getEmail());
        professor.setAreaAtuacao(dto.getAreaAtuacao());
        professor.setTitulacao(dto.getTitulacao());

        return repository.save(professor);
    }

    @Transactional
    public void deletarProfessor(Long id) {
        if (!repository.existsById(id)) {
            throw new ProfessorNotFoundException(id);
        }
        repository.deleteById(id);
    }
}