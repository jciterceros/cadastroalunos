package com.jciterceros.cadastroalunos.service;

import com.jciterceros.cadastroalunos.dto.EventoDTO;
import com.jciterceros.cadastroalunos.exception.EventoNotFoundException;
import com.jciterceros.cadastroalunos.model.Evento;
import com.jciterceros.cadastroalunos.model.PeriodoLetivo;
import com.jciterceros.cadastroalunos.model.Professor;
import com.jciterceros.cadastroalunos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private PeriodoLetivoService periodoLetivoService;

    @Autowired
    private ProfessorService professorService;

    @Transactional
    public Evento cadastrarEvento(EventoDTO dto) {
        if (repository.existsByTituloAndPeriodoLetivoId(dto.getTitulo(), dto.getPeriodoLetivoId())) {
            throw new RuntimeException("Já existe um evento com este título no período letivo informado");
        }

        PeriodoLetivo periodo = periodoLetivoService.buscarPorId(dto.getPeriodoLetivoId());
        Professor professor = professorService.buscarPorId(dto.getProfessorId());

        Evento evento = new Evento();
        evento.setTitulo(dto.getTitulo());
        evento.setDescricao(dto.getDescricao());
        evento.setDataInicio(dto.getDataInicio());
        evento.setDataFim(dto.getDataFim());
        evento.setTipo(dto.getTipo());
        evento.setPeriodoLetivo(periodo);
        evento.setProfessor(professor);

        return repository.save(evento);
    }

    public Page<Evento> listarEventos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Evento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EventoNotFoundException(id));
    }

    @Transactional
    public Evento atualizarEvento(Long id, EventoDTO dto) {
        Evento evento = buscarPorId(id);

        if (!evento.getTitulo().equals(dto.getTitulo()) ||
                !evento.getPeriodoLetivo().getId().equals(dto.getPeriodoLetivoId())) {
            if (repository.existsByTituloAndPeriodoLetivoId(dto.getTitulo(), dto.getPeriodoLetivoId())) {
                throw new RuntimeException("Já existe um evento com este título no período letivo informado");
            }
        }

        PeriodoLetivo periodo = periodoLetivoService.buscarPorId(dto.getPeriodoLetivoId());
        Professor professor = professorService.buscarPorId(dto.getProfessorId());

        evento.setTitulo(dto.getTitulo());
        evento.setDescricao(dto.getDescricao());
        evento.setDataInicio(dto.getDataInicio());
        evento.setDataFim(dto.getDataFim());
        evento.setTipo(dto.getTipo());
        evento.setPeriodoLetivo(periodo);
        evento.setProfessor(professor);

        return repository.save(evento);
    }

    @Transactional
    public void deletarEvento(Long id) {
        if (!repository.existsById(id)) {
            throw new EventoNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Page<Evento> buscarPorPeriodoLetivo(Long periodoLetivoId, Pageable pageable) {
        return repository.findByPeriodoLetivoId(periodoLetivoId, pageable);
    }

    public Page<Evento> buscarPorProfessor(Long professorId, Pageable pageable) {
        return repository.findByProfessorId(professorId, pageable);
    }
}