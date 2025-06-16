package com.jciterceros.cadastroalunos.repository;

import com.jciterceros.cadastroalunos.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    boolean existsByMatricula(String matricula);

    boolean existsByEmail(String email);
}