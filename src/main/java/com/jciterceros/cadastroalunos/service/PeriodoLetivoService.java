package com.jciterceros.cadastroalunos.service;

import com.jciterceros.cadastroalunos.dto.PeriodoLetivoDTO;
import com.jciterceros.cadastroalunos.exception.PeriodoLetivoNotFoundException;
import com.jciterceros.cadastroalunos.model.PeriodoLetivo;
import com.jciterceros.cadastroalunos.repository.PeriodoLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeriodoLetivoService {

    @Autowired
    private PeriodoLetivoRepository repository;

    @Transactional
    public PeriodoLetivo cadastrarPeriodoLetivo(PeriodoLetivoDTO dto) {
        if (repository.existsByAnoAndSemestre(dto.getAno(), dto.getSemestre())) {
            throw new RuntimeException("Já existe um período letivo para o ano " + dto.getAno() +
                    " e semestre " + dto.getSemestre());
        }

        PeriodoLetivo periodo = new PeriodoLetivo();
        periodo.setNome(dto.getNome());
        periodo.setDataInicio(dto.getDataInicio());
        periodo.setDataFim(dto.getDataFim());
        periodo.setAno(dto.getAno());
        periodo.setSemestre(dto.getSemestre());
        periodo.setStatus(dto.getStatus());

        return repository.save(periodo);
    }

    public Page<PeriodoLetivo> listarPeriodosLetivos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public PeriodoLetivo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PeriodoLetivoNotFoundException(id));
    }

    @Transactional
    public PeriodoLetivo atualizarPeriodoLetivo(Long id, PeriodoLetivoDTO dto) {
        PeriodoLetivo periodo = buscarPorId(id);

        // Verifica se já existe outro período com o mesmo ano e semestre
        if (!(periodo.getAno().equals(dto.getAno()) && periodo.getSemestre().equals(dto.getSemestre())) &&
                repository.existsByAnoAndSemestre(dto.getAno(), dto.getSemestre())) {
            throw new RuntimeException("Já existe um período letivo para o ano " + dto.getAno() +
                    " e semestre " + dto.getSemestre());
        }

        periodo.setNome(dto.getNome());
        periodo.setDataInicio(dto.getDataInicio());
        periodo.setDataFim(dto.getDataFim());
        periodo.setAno(dto.getAno());
        periodo.setSemestre(dto.getSemestre());
        periodo.setStatus(dto.getStatus());

        return repository.save(periodo);
    }

    @Transactional
    public void deletarPeriodoLetivo(Long id) {
        if (!repository.existsById(id)) {
            throw new PeriodoLetivoNotFoundException(id);
        }
        repository.deleteById(id);
    }
}