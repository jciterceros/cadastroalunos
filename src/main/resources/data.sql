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