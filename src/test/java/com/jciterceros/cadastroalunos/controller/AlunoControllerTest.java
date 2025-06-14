package com.jciterceros.cadastroalunos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jciterceros.cadastroalunos.dto.AlunoDTO;
import com.jciterceros.cadastroalunos.model.Aluno;
import com.jciterceros.cadastroalunos.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class)
class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
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
    void create_Success() throws Exception {
        when(alunoService.cadastrarAluno(any(AlunoDTO.class))).thenReturn(aluno);

        mockMvc.perform(post("/alunos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(aluno.getId()))
                .andExpect(jsonPath("$.nome").value(aluno.getNome()))
                .andExpect(jsonPath("$.matricula").value(aluno.getMatricula()))
                .andExpect(jsonPath("$.email").value(aluno.getEmail()));

        verify(alunoService).cadastrarAluno(any(AlunoDTO.class));
    }

    @Test
    void list_Success() throws Exception {
        Page<Aluno> alunoPage = new PageImpl<>(Arrays.asList(aluno));
        when(alunoService.listarAlunos(any(PageRequest.class))).thenReturn(alunoPage);

        mockMvc.perform(get("/alunos")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(aluno.getId()))
                .andExpect(jsonPath("$.content[0].nome").value(aluno.getNome()))
                .andExpect(jsonPath("$.totalElements").value(1));

        verify(alunoService).listarAlunos(any(PageRequest.class));
    }

    @Test
    void getById_Success() throws Exception {
        when(alunoService.buscarAlunoPorId(1L)).thenReturn(aluno);

        mockMvc.perform(get("/alunos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(aluno.getId()))
                .andExpect(jsonPath("$.nome").value(aluno.getNome()))
                .andExpect(jsonPath("$.matricula").value(aluno.getMatricula()))
                .andExpect(jsonPath("$.email").value(aluno.getEmail()));

        verify(alunoService).buscarAlunoPorId(1L);
    }

    @Test
    void update_Success() throws Exception {
        when(alunoService.atualizarAluno(eq(1L), any(AlunoDTO.class))).thenReturn(aluno);

        mockMvc.perform(put("/alunos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(aluno.getId()))
                .andExpect(jsonPath("$.nome").value(aluno.getNome()))
                .andExpect(jsonPath("$.matricula").value(aluno.getMatricula()))
                .andExpect(jsonPath("$.email").value(aluno.getEmail()));

        verify(alunoService).atualizarAluno(eq(1L), any(AlunoDTO.class));
    }

    @Test
    void delete_Success() throws Exception {
        doNothing().when(alunoService).deletarAluno(1L);

        mockMvc.perform(delete("/alunos/1"))
                .andExpect(status().isNoContent());

        verify(alunoService).deletarAluno(1L);
    }
}