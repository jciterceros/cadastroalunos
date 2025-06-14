package com.jciterceros.cadastroalunos.repository;

import com.jciterceros.cadastroalunos.model.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AlunoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    void whenFindById_thenReturnAluno() {
        // given
        Aluno aluno = new Aluno();
        aluno.setNome("João Silva");
        aluno.setMatricula("2023001");
        aluno.setEmail("joao.silva@email.com");
        aluno.setDataNascimento(LocalDate.of(2000, 1, 1));
        aluno.setTelefone("(11) 99999-9999");
        aluno.setEndereco("Rua Teste, 123");
        aluno.setCurso("Engenharia");
        aluno.setPeriodo(3);
        aluno.setStatusMatricula(Aluno.StatusMatricula.ATIVO);

        entityManager.persist(aluno);
        entityManager.flush();

        // when
        Optional<Aluno> found = alunoRepository.findById(aluno.getId());

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getNome()).isEqualTo(aluno.getNome());
        assertThat(found.get().getMatricula()).isEqualTo(aluno.getMatricula());
        assertThat(found.get().getEmail()).isEqualTo(aluno.getEmail());
    }

    @Test
    void whenExistsByMatricula_thenReturnTrue() {
        // given
        Aluno aluno = new Aluno();
        aluno.setNome("João Silva");
        aluno.setMatricula("2023001");
        aluno.setEmail("joao.silva@email.com");
        aluno.setDataNascimento(LocalDate.of(2000, 1, 1));
        aluno.setTelefone("(11) 99999-9999");
        aluno.setEndereco("Rua Teste, 123");
        aluno.setCurso("Engenharia");
        aluno.setPeriodo(3);
        aluno.setStatusMatricula(Aluno.StatusMatricula.ATIVO);

        entityManager.persist(aluno);
        entityManager.flush();

        // when
        boolean exists = alunoRepository.existsByMatricula(aluno.getMatricula());

        // then
        assertThat(exists).isTrue();
    }

    @Test
    void whenExistsByEmail_thenReturnTrue() {
        // given
        Aluno aluno = new Aluno();
        aluno.setNome("João Silva");
        aluno.setMatricula("2023001");
        aluno.setEmail("joao.silva@email.com");
        aluno.setDataNascimento(LocalDate.of(2000, 1, 1));
        aluno.setTelefone("(11) 99999-9999");
        aluno.setEndereco("Rua Teste, 123");
        aluno.setCurso("Engenharia");
        aluno.setPeriodo(3);
        aluno.setStatusMatricula(Aluno.StatusMatricula.ATIVO);

        entityManager.persist(aluno);
        entityManager.flush();

        // when
        boolean exists = alunoRepository.existsByEmail(aluno.getEmail());

        // then
        assertThat(exists).isTrue();
    }

    @Test
    void whenDeleteById_thenAlunoShouldNotExist() {
        // given
        Aluno aluno = new Aluno();
        aluno.setNome("João Silva");
        aluno.setMatricula("2023001");
        aluno.setEmail("joao.silva@email.com");
        aluno.setDataNascimento(LocalDate.of(2000, 1, 1));
        aluno.setTelefone("(11) 99999-9999");
        aluno.setEndereco("Rua Teste, 123");
        aluno.setCurso("Engenharia");
        aluno.setPeriodo(3);
        aluno.setStatusMatricula(Aluno.StatusMatricula.ATIVO);

        entityManager.persist(aluno);
        entityManager.flush();

        // when
        alunoRepository.deleteById(aluno.getId());
        Optional<Aluno> deleted = alunoRepository.findById(aluno.getId());

        // then
        assertThat(deleted).isEmpty();
    }
}