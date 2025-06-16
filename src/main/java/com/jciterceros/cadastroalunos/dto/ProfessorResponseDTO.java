package com.jciterceros.cadastroalunos.dto;

import com.jciterceros.cadastroalunos.model.Professor;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProfessorResponseDTO {
    private Long id;
    private String nome;
    private String matricula;
    private String email;
    private String areaAtuacao;
    private String titulacao;
    private List<EventoResponseDTO> eventos;

    public static ProfessorResponseDTO fromEntity(Professor professor) {
        ProfessorResponseDTO dto = new ProfessorResponseDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setMatricula(professor.getMatricula());
        dto.setEmail(professor.getEmail());
        dto.setAreaAtuacao(professor.getAreaAtuacao());
        dto.setTitulacao(professor.getTitulacao());

        if (professor.getEventos() != null) {
            dto.setEventos(professor.getEventos().stream()
                    .map(EventoResponseDTO::fromEntity)
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}