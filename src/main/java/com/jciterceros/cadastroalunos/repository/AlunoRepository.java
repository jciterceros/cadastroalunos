package com.jciterceros.cadastroalunos.repository;

import com.jciterceros.cadastroalunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    boolean existsByMatricula(String matricula);

    boolean existsByEmail(String email);
}