# Architecture Decision Records (ADRs)

Este diretório contém os registros de decisões arquiteturais (ADRs) do projeto. ADRs são documentos que capturam decisões arquiteturais importantes, incluindo o contexto e as consequências da decisão.

## Estrutura dos ADRs

Cada ADR segue o seguinte formato:

```markdown
# ADR [número]: [título]

## Status
[Aceito/Proposto/Depreciado/Superado]

## Contexto
[Descrição do problema ou situação que levou à decisão]

## Decisão
[Descrição da decisão tomada]

## Consequências
### Positivas
- [Lista de consequências positivas]

### Negativas
- [Lista de consequências negativas]

## Alternativas Consideradas
1. [Alternativa 1]
   - Prós: [pontos positivos]
   - Contras: [pontos negativos]
```

## ADRs Existentes

1. [ADR-0001](0001-use-c4-model-for-documentation.md) - Uso do Modelo C4 para Documentação de Arquitetura
2. [ADR-0002](0002-spring-boot-framework-choice.md) - Uso do Spring Boot como Framework Principal
3. [ADR-0003](0003-database-strategy.md) - Estratégia de Banco de Dados

## Como Criar um Novo ADR

1. Copie o template do ADR mais recente
2. Incremente o número do ADR
3. Preencha todas as seções
4. Adicione o novo ADR à lista acima
5. Faça commit das alterações

## Status dos ADRs

- **Aceito**: Decisão implementada e em uso
- **Proposto**: Decisão em discussão
- **Depreciado**: Decisão não mais em uso
- **Superado**: Decisão substituída por outra 