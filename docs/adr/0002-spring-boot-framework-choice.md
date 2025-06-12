# ADR 0002: Uso do Spring Boot como Framework Principal

## Status

Aceito

## Contexto

Precisamos escolher um framework para desenvolver a API de cadastro de alunos. O framework deve:
- Ser robusto e maduro
- Ter bom suporte da comunidade
- Oferecer recursos necessários para o projeto
- Ter boa performance
- Ser fácil de manter e escalar

## Decisão

Adotaremos o Spring Boot como framework principal do projeto pelos seguintes motivos:
- Framework maduro e amplamente utilizado
- Excelente suporte para desenvolvimento de APIs REST
- Integração nativa com JPA/Hibernate para persistência
- Suporte a diferentes bancos de dados
- Grande ecossistema de bibliotecas e ferramentas
- Documentação extensa e comunidade ativa

## Consequências

### Positivas
- Desenvolvimento rápido com recursos prontos
- Boa performance e escalabilidade
- Fácil integração com outras tecnologias
- Grande disponibilidade de desenvolvedores
- Suporte a testes unitários e de integração

### Negativas
- Curva de aprendizado para novos desenvolvedores
- Overhead de configuração inicial
- Possível complexidade em casos muito simples

## Alternativas Consideradas

1. **Node.js com Express**
   - Prós: JavaScript, mais simples para iniciantes
   - Contras: Menos maduro para aplicações empresariais

2. **Quarkus**
   - Prós: Mais leve, startup mais rápido
   - Contras: Menos maduro, comunidade menor

3. **Micronaut**
   - Prós: Framework moderno, boa performance
   - Contras: Menos maduro, menos recursos prontos 