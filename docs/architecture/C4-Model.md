# Modelo C4 - Documentação de Arquitetura

## Visão Geral
O Modelo C4 é uma forma de documentar a arquitetura de software através de quatro níveis de abstração, cada um com um propósito específico e público-alvo diferente.

## Níveis do Modelo C4

### 1. Nível de Contexto (C1) – Diagrama de Sistema
**Público**: Stakeholders não técnicos (gestores, clientes)

**Foco**: Como o sistema se relaciona com usuários e sistemas externos.

![Diagrama de Contexto](../images/C1-Contexto.png)

**Atores**:
- Professores
- Secretaria

**Sistemas externos**:
- Banco de Dados
- Sistema de E-mail
- API Histórico Escolar

### 2. Nível de Contêineres (C2) – Diagrama de Componentes
**Público**: Arquitetos e desenvolvedores

**Foco**: Tecnologias e serviços principais.

![Diagrama de Containers](../images/C2-Containers.png)

**Tecnologias**:
- API: Spring Boot
- Banco de Dados: H2 (Desenvolvimento) / PostgreSQL (Produção)
- Infra: AWS EC2 + Load Balancer

### 3. Nível de Componentes (C3) – Detalhamento Interno
**Público**: Desenvolvedores

**Foco**: Módulos da API.

![Diagrama de Componentes](../images/C3-Components.png)

**Componentes Principais**
- Controller: Rotas REST (POST /alunos, GET /alunos)
- Service: Lógica de negócio (validação, regras de cadastro)
- Repository: Acesso ao banco de dados
- Integrações: Comunicação com serviços externos

### 4. Nível de Código (C4) – Detalhamento de Implementação
**Público**: Desenvolvedores (apenas para partes críticas)

**Foco**: Detalhes de implementação específicos.

#### Exemplo de Implementação
```java
@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody AlunoDTO dto) {
        Aluno aluno = service.cadastrarAluno(dto);
        return ResponseEntity.ok(aluno);
    }
}
```
## 🛠️ Tecnologias Utilizadas

| Função | Tecnologia |
|--------|------------|
| Backend | Spring Boot (Java 21) |
| Banco de Dados | H2 (Dev) / PostgreSQL (Prod) |
| Autenticação | JWT |
| Deploy | Docker + AWS ECS |


## Benefícios da Modelagem C4
- **Clareza**: Cada nível atende a um público específico
- **Manutenção**: Facilita a identificação de pontos de melhoria
- **Escalabilidade**: Mostra dependências críticas (ex: integração com e-mail) 