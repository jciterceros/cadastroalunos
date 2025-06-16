package com.jciterceros.cadastroalunos.repository;

import com.jciterceros.cadastroalunos.model.PeriodoLetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoLetivoRepository extends JpaRepository<PeriodoLetivo, Long> {
    boolean existsByAnoAndSemestre(Integer ano, Integer semestre);
}