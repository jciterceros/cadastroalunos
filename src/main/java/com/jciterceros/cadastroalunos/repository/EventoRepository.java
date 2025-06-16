package com.jciterceros.cadastroalunos.repository;

import com.jciterceros.cadastroalunos.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    Page<Evento> findByPeriodoLetivoId(Long periodoLetivoId, Pageable pageable);

    Page<Evento> findByProfessorId(Long professorId, Pageable pageable);

    boolean existsByTituloAndPeriodoLetivoId(String titulo, Long periodoLetivoId);
}