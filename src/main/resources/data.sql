-- Limpa a tabela antes de inserir novos dados
DELETE FROM alunos;

-- Insere 20 registros de alunos
INSERT INTO alunos (nome, matricula, email, data_nascimento, telefone, endereco, curso, periodo, status_matricula) VALUES
('João Silva', '2024001', 'joao.silva@email.com', '2000-05-15', '(11) 98765-4321', 'Rua das Flores, 123 - São Paulo', 'Ciência da Computação', 4, 'ATIVO'),
('Maria Oliveira', '2024002', 'maria.oliveira@email.com', '2001-03-20', '(11) 91234-5678', 'Av. Paulista, 1000 - São Paulo', 'Engenharia Civil', 2, 'ATIVO'),
('Pedro Santos', '2024003', 'pedro.santos@email.com', '1999-11-10', '(11) 99876-5432', 'Rua Augusta, 500 - São Paulo', 'Administração', 6, 'ATIVO'),
('Ana Costa', '2024004', 'ana.costa@email.com', '2002-07-25', '(11) 97777-8888', 'Rua Consolação, 200 - São Paulo', 'Medicina', 1, 'ATIVO'),
('Lucas Ferreira', '2024005', 'lucas.ferreira@email.com', '2000-09-30', '(11) 96666-5555', 'Av. Rebouças, 1500 - São Paulo', 'Direito', 3, 'ATIVO'),
('Julia Lima', '2024006', 'julia.lima@email.com', '2001-12-05', '(11) 95555-4444', 'Rua Oscar Freire, 300 - São Paulo', 'Psicologia', 2, 'ATIVO'),
('Rafael Souza', '2024007', 'rafael.souza@email.com', '1999-04-18', '(11) 94444-3333', 'Av. Brigadeiro Faria Lima, 2000 - São Paulo', 'Engenharia Elétrica', 5, 'ATIVO'),
('Beatriz Almeida', '2024008', 'beatriz.almeida@email.com', '2002-01-22', '(11) 93333-2222', 'Rua Haddock Lobo, 400 - São Paulo', 'Arquitetura', 1, 'ATIVO'),
('Gabriel Martins', '2024009', 'gabriel.martins@email.com', '2000-08-14', '(11) 92222-1111', 'Av. Berrini, 1000 - São Paulo', 'Ciência da Computação', 4, 'ATIVO'),
('Isabela Pereira', '2024010', 'isabela.pereira@email.com', '2001-06-28', '(11) 91111-0000', 'Rua da Consolação, 1500 - São Paulo', 'Medicina', 2, 'ATIVO'),
('Matheus Rodrigues', '2024011', 'matheus.rodrigues@email.com', '1999-10-03', '(11) 90000-9999', 'Av. Paulista, 2000 - São Paulo', 'Engenharia Civil', 6, 'ATIVO'),
('Laura Gomes', '2024012', 'laura.gomes@email.com', '2002-02-17', '(11) 99999-8888', 'Rua Augusta, 1000 - São Paulo', 'Psicologia', 1, 'ATIVO'),
('Bruno Carvalho', '2024013', 'bruno.carvalho@email.com', '2000-07-09', '(11) 98888-7777', 'Av. Rebouças, 2500 - São Paulo', 'Direito', 3, 'ATIVO'),
('Mariana Santos', '2024014', 'mariana.santos@email.com', '2001-04-12', '(11) 97777-6666', 'Rua Oscar Freire, 500 - São Paulo', 'Arquitetura', 2, 'ATIVO'),
('Thiago Oliveira', '2024015', 'thiago.oliveira@email.com', '1999-12-25', '(11) 96666-5555', 'Av. Brigadeiro Faria Lima, 3000 - São Paulo', 'Engenharia Elétrica', 5, 'ATIVO'),
('Camila Silva', '2024016', 'camila.silva@email.com', '2002-03-08', '(11) 95555-4444', 'Rua Haddock Lobo, 600 - São Paulo', 'Administração', 1, 'ATIVO'),
('Leonardo Costa', '2024017', 'leonardo.costa@email.com', '2000-11-19', '(11) 94444-3333', 'Av. Berrini, 2000 - São Paulo', 'Ciência da Computação', 4, 'ATIVO'),
('Amanda Ferreira', '2024018', 'amanda.ferreira@email.com', '2001-09-01', '(11) 93333-2222', 'Rua da Consolação, 2000 - São Paulo', 'Medicina', 2, 'ATIVO'),
('Guilherme Lima', '2024019', 'guilherme.lima@email.com', '1999-05-27', '(11) 92222-1111', 'Av. Paulista, 3000 - São Paulo', 'Engenharia Civil', 6, 'ATIVO'),
('Carolina Souza', '2024020', 'carolina.souza@email.com', '2002-08-15', '(11) 91111-0000', 'Rua Augusta, 1500 - São Paulo', 'Psicologia', 1, 'ATIVO');

-- Professores
INSERT INTO professores (nome, matricula, email, area_atuacao, titulacao) VALUES
('Dr. João Silva', '1234567', 'joao.silva@email.com', 'Matemática', 'Doutor'),
('Dra. Maria Santos', '2345678', 'maria.santos@email.com', 'Física', 'Doutora'),
('Prof. Carlos Oliveira', '3456789', 'carlos.oliveira@email.com', 'Química', 'Mestre'),
('Dra. Ana Pereira', '4567890', 'ana.pereira@email.com', 'Biologia', 'Doutora'),
('Prof. Pedro Costa', '5678901', 'pedro.costa@email.com', 'História', 'Mestre'),
('Dra. Juliana Lima', '6789012', 'juliana.lima@email.com', 'Geografia', 'Doutora'),
('Prof. Roberto Alves', '7890123', 'roberto.alves@email.com', 'Literatura', 'Mestre'),
('Dra. Fernanda Martins', '8901234', 'fernanda.martins@email.com', 'Filosofia', 'Doutora'),
('Prof. Marcelo Souza', '9012345', 'marcelo.souza@email.com', 'Sociologia', 'Mestre'),
('Dra. Patricia Costa', '0123456', 'patricia.costa@email.com', 'Psicologia', 'Doutora');

-- Períodos Letivos
INSERT INTO periodos_letivos (nome, data_inicio, data_fim, ano, semestre, status_periodo) VALUES
('2023.1', '2023-02-01', '2023-07-15', 2023, 1, 'CONCLUIDO'),
('2023.2', '2023-08-01', '2023-12-15', 2023, 2, 'CONCLUIDO'),
('2024.1', '2024-02-01', '2024-07-15', 2024, 1, 'EM_ANDAMENTO'),
('2024.2', '2024-08-01', '2024-12-15', 2024, 2, 'PLANEJADO'),
('2025.1', '2025-02-01', '2025-07-15', 2025, 1, 'PLANEJADO');

-- Eventos
INSERT INTO eventos (titulo, descricao, data_inicio, data_fim, tipo_evento, periodo_letivo_id, professor_id) VALUES
('Semana de Matemática', 'Evento com palestras e workshops sobre matemática aplicada', '2024-03-15 09:00:00', '2024-03-19 18:00:00', 'OUTRO', 3, 1),
('Olimpíada de Física', 'Competição de física para alunos do ensino médio', '2024-04-20 08:00:00', '2024-04-20 17:00:00', 'AVALIACAO', 3, 2),
('Feira de Ciências', 'Apresentação de projetos científicos dos alunos', '2024-05-10 09:00:00', '2024-05-12 18:00:00', 'OUTRO', 3, 3),
('Palestra: Química Verde', 'Introdução aos conceitos de química sustentável', '2024-03-25 14:00:00', '2024-03-25 16:00:00', 'PALESTRA', 3, 3),
('Workshop de Biologia', 'Práticas laboratoriais em biologia molecular', '2024-04-05 13:00:00', '2024-04-05 17:00:00', 'TRABALHO_PRATICO', 3, 4),
('Simpósio de História', 'Debates sobre história contemporânea', '2024-05-15 09:00:00', '2024-05-17 18:00:00', 'OUTRO', 3, 5),
('Congresso de Geografia', 'Discussões sobre geografia urbana e ambiental', '2024-06-01 08:00:00', '2024-06-03 18:00:00', 'OUTRO', 3, 6),
('Sarau Literário', 'Apresentações de poesia e literatura', '2024-04-30 19:00:00', '2024-04-30 22:00:00', 'OUTRO', 3, 7),
('Debate Filosófico', 'Discussão sobre ética e moral na sociedade atual', '2024-05-20 14:00:00', '2024-05-20 17:00:00', 'REUNIAO', 3, 8),
('Oficina de Sociologia', 'Análise de dados sociais e pesquisas de campo', '2024-06-10 13:00:00', '2024-06-10 17:00:00', 'TRABALHO_PRATICO', 3, 9),
('Seminário de Psicologia', 'Temas atuais em psicologia clínica', '2024-06-15 09:00:00', '2024-06-16 18:00:00', 'OUTRO', 3, 10),
('Mostra Cultural', 'Exposição de trabalhos artísticos dos alunos', '2024-07-01 10:00:00', '2024-07-05 20:00:00', 'OUTRO', 3, 1),
('Workshop de Programação', 'Introdução à programação para iniciantes', '2024-03-20 13:00:00', '2024-03-20 17:00:00', 'TRABALHO_PRATICO', 3, 2),
('Palestra: Inteligência Artificial', 'Impactos da IA na educação', '2024-04-25 14:00:00', '2024-04-25 16:00:00', 'PALESTRA', 3, 3),
('Feira de Profissões', 'Orientação profissional para estudantes', '2024-05-30 09:00:00', '2024-05-30 17:00:00', 'OUTRO', 3, 4),
('Semana de Tecnologia', 'Evento sobre inovações tecnológicas', '2024-06-20 09:00:00', '2024-06-24 18:00:00', 'OUTRO', 3, 5),
('Olimpíada de Matemática', 'Competição de matemática para alunos', '2024-07-05 08:00:00', '2024-07-05 17:00:00', 'AVALIACAO', 3, 6),
('Congresso de Educação', 'Debates sobre metodologias de ensino', '2024-07-10 09:00:00', '2024-07-12 18:00:00', 'OUTRO', 3, 7),
('Simpósio de Pesquisa', 'Apresentação de pesquisas acadêmicas', '2024-07-15 09:00:00', '2024-07-17 18:00:00', 'OUTRO', 3, 8),
('Encontro de Egressos', 'Reunião com ex-alunos para networking', '2024-07-20 14:00:00', '2024-07-20 18:00:00', 'REUNIAO', 3, 9); 