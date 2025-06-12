# Guia de Instalação e Configuração

## Pré-requisitos

- JDK 21 ou superior
- Maven 3.6.x ou superior
- Docker e Docker Compose (para ambiente de produção)
- Git

## Instalação

### 1. Clone o Repositório

```bash
git clone https://github.com/jciterceros/cadastroalunos.git
cd cadastroalunos
```

### 2. Configuração do Ambiente de Desenvolvimento

#### Usando Maven

1. Compile o projeto:
```bash
./mvnw clean install
```

2. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

#### Usando Docker (Desenvolvimento)

1. Construa a imagem:
```bash
docker build -t cadastroalunos:dev .
```

2. Execute o container:
```bash
docker run -p 8080:8080 cadastroalunos:dev
```

### 3. Configuração do Ambiente de Produção

#### Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto:

```properties
SPRING_PROFILES_ACTIVE=prod
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/cadastroalunos
SPRING_DATASOURCE_USERNAME=seu_usuario
SPRING_DATASOURCE_PASSWORD=sua_senha
JWT_SECRET=seu_segredo_jwt
```

#### Usando Docker Compose (Produção)

1. Execute o stack completo:
```bash
docker-compose up -d
```

## Configuração do Banco de Dados

### Desenvolvimento (H2)

O banco de dados H2 é configurado automaticamente em memória. Não é necessária configuração adicional.

### Produção (PostgreSQL)

1. Crie o banco de dados:
```sql
CREATE DATABASE cadastroalunos;
```

2. Execute as migrações:
```bash
./mvnw flyway:migrate
```

## Configuração de Segurança

### JWT

1. Gere uma chave secreta:
```bash
openssl rand -base64 32
```

2. Configure a chave no arquivo `application.properties`:
```properties
jwt.secret=sua_chave_gerada
```

## Monitoramento

A aplicação inclui endpoints de monitoramento:

- Health Check: `http://localhost:8080/actuator/health`
- Métricas: `http://localhost:8080/actuator/metrics`
- Info: `http://localhost:8080/actuator/info`

## Troubleshooting

### Problemas Comuns

1. **Porta 8080 em uso**
   - Altere a porta no `application.properties`:
   ```properties
   server.port=8081
   ```

2. **Erro de conexão com banco de dados**
   - Verifique as credenciais no arquivo `.env`
   - Confirme se o banco de dados está rodando

3. **Erro de compilação**
   - Verifique se o JDK 21 está instalado:
   ```bash
   java -version
   ```
   - Limpe o cache do Maven:
   ```bash
   ./mvnw clean
   ``` 