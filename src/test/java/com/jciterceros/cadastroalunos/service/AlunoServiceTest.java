package com.jciterceros.cadastroalunos.service;

import com.jciterceros.cadastroalunos.dto.AlunoDTO;
import com.jciterceros.cadastroalunos.exception.AlunoNotFoundException;
import com.jciterceros.cadastroalunos.exception.DuplicateEmailException;
import com.jciterceros.cadastroalunos.exception.DuplicateMatriculaException;
import com.jciterceros.cadastroalunos.model.Aluno;
import com.jciterceros.cadastroalunos.repository.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    private AlunoDTO alunoDTO;
    private Aluno aluno;

    @BeforeEach
    void setUp() {
        alunoDTO = new AlunoDTO();
        alunoDTO.setNome("João Silva");
        alunoDTO.setMatricula("2023001");
        alunoDTO.setEmail("joao.silva@email.com");
        alunoDTO.setDataNascimento(LocalDate.of(2000, 1, 1));
        alunoDTO.setTelefone("(11) 99999-9999");
        alunoDTO.setEndereco("Rua Teste, 123");
        alunoDTO.setCurso("Engenharia");
        alunoDTO.setPeriodo(3);
        alunoDTO.setStatusMatricula(Aluno.StatusMatricula.ATIVO);

        aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome(alunoDTO.getNome());
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setDataNascimento(alunoDTO.getDataNascimento());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setEndereco(alunoDTO.getEndereco());
        aluno.setCurso(alunoDTO.getCurso());
        aluno.setPeriodo(alunoDTO.getPeriodo());
        aluno.setStatusMatricula(alunoDTO.getStatusMatricula());
    }

    @Test
    void cadastrarAluno_Success() {
        when(alunoRepository.existsByMatricula(anyString())).thenReturn(false);
        when(alunoRepository.existsByEmail(anyString())).thenReturn(false);
        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoService.cadastrarAluno(alunoDTO);

        assertNotNull(result);
        assertEquals(alunoDTO.getNome(), result.getNome());
        assertEquals(alunoDTO.getMatricula(), result.getMatricula());
        assertEquals(alunoDTO.getEmail(), result.getEmail());
        verify(alunoRepository).save(any(Aluno.class));
    }

    @Test
    void cadastrarAluno_DuplicateMatricula() {
        when(alunoRepository.existsByMatricula(anyString())).thenReturn(true);

        assertThrows(DuplicateMatriculaException.class, () -> alunoService.cadastrarAluno(alunoDTO));
        verify(alunoRepository, never()).save(any(Aluno.class));
    }

    @Test
    void cadastrarAluno_DuplicateEmail() {
        when(alunoRepository.existsByMatricula(anyString())).thenReturn(false);
        when(alunoRepository.existsByEmail(anyString())).thenReturn(true);

        assertThrows(DuplicateEmailException.class, () -> alunoService.cadastrarAluno(alunoDTO));
        verify(alunoRepository, never()).save(any(Aluno.class));
    }

    @Test
    void listarAlunos_Success() {
        List<Aluno> alunos = Arrays.asList(aluno);
        Page<Aluno> alunoPage = new PageImpl<>(alunos);
        Pageable pageable = PageRequest.of(0, 10);

        when(alunoRepository.findAll(pageable)).thenReturn(alunoPage);

        Page<Aluno> result = alunoService.listarAlunos(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(aluno.getNome(), result.getContent().get(0).getNome());
    }

    @Test
    void buscarAlunoPorId_Success() {
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        Aluno result = alunoService.buscarAlunoPorId(1L);

        assertNotNull(result);
        assertEquals(aluno.getId(), result.getId());
        assertEquals(aluno.getNome(), result.getNome());
    }

    @Test
    void buscarAlunoPorId_NotFound() {
        when(alunoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(AlunoNotFoundException.class, () -> alunoService.buscarAlunoPorId(1L));
    }

    @Test
    void atualizarAluno_Success() {
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));
        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoService.atualizarAluno(1L, alunoDTO);

        assertNotNull(result);
        assertEquals(alunoDTO.getNome(), result.getNome());
        assertEquals(alunoDTO.getMatricula(), result.getMatricula());
        assertEquals(alunoDTO.getEmail(), result.getEmail());
        verify(alunoRepository).save(any(Aluno.class));
    }

    @Test
    void deletarAluno_Success() {
        when(alunoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(alunoRepository).deleteById(1L);

        assertDoesNotThrow(() -> alunoService.deletarAluno(1L));
        verify(alunoRepository).deleteById(1L);
    }

    @Test
    void deletarAluno_NotFound() {
        when(alunoRepository.existsById(1L)).thenReturn(false);

        assertThrows(AlunoNotFoundException.class, () -> alunoService.deletarAluno(1L));
        verify(alunoRepository, never()).deleteById(anyLong());
    }
}