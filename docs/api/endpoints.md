# Documentação da API

## Endpoints

### Alunos

#### Listar Alunos
```http
GET /api/alunos
```

**Resposta**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "matricula": "2024001",
    "email": "joao.silva@email.com",
    "dataNascimento": "2000-01-01"
  }
]
```

#### Buscar Aluno por ID
```http
GET /api/alunos/{id}
```

**Resposta**
```json
{
  "id": 1,
  "nome": "João Silva",
  "matricula": "2024001",
  "email": "joao.silva@email.com",
  "dataNascimento": "2000-01-01"
}
```

#### Criar Aluno
```http
POST /api/alunos
```

**Request Body**
```json
{
  "nome": "João Silva",
  "matricula": "2024001",
  "email": "joao.silva@email.com",
  "dataNascimento": "2000-01-01"
}
```

**Resposta**
```json
{
  "id": 1,
  "nome": "João Silva",
  "matricula": "2024001",
  "email": "joao.silva@email.com",
  "dataNascimento": "2000-01-01"
}
```

#### Atualizar Aluno
```http
PUT /api/alunos/{id}
```

**Request Body**
```json
{
  "nome": "João Silva Atualizado",
  "email": "joao.silva.novo@email.com"
}
```

**Resposta**
```json
{
  "id": 1,
  "nome": "João Silva Atualizado",
  "matricula": "2024001",
  "email": "joao.silva.novo@email.com",
  "dataNascimento": "2000-01-01"
}
```

#### Deletar Aluno
```http
DELETE /api/alunos/{id}
```

**Resposta**
```http
204 No Content
```

## Códigos de Status

- 200: Sucesso
- 201: Criado
- 204: Sem conteúdo
- 400: Requisição inválida
- 404: Não encontrado
- 500: Erro interno do servidor

## Autenticação

A API utiliza autenticação JWT. Para acessar os endpoints protegidos, inclua o token no header:

```http
Authorization: Bearer <seu-token-jwt>
``` 