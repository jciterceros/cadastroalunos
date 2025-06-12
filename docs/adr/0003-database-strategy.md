# ADR 0003: Estratégia de Banco de Dados

## Status

Aceito

## Contexto

Precisamos definir uma estratégia de banco de dados que:
- Suporte o desenvolvimento local
- Seja adequada para produção
- Permita fácil migração entre ambientes
- Ofereça boa performance
- Seja confiável e segura

## Decisão

Adotaremos uma estratégia de banco de dados com:
1. **Desenvolvimento**: H2 Database
   - Banco em memória para desenvolvimento
   - Fácil configuração
   - Não requer instalação

2. **Produção**: PostgreSQL
   - Banco relacional robusto
   - Boa performance
   - Suporte a transações ACID
   - Recursos avançados de segurança

3. **Migração**: Flyway
   - Controle de versão do banco
   - Migrações automáticas
   - Histórico de alterações

## Consequências

### Positivas
- Ambiente de desenvolvimento simplificado
- Banco de dados robusto em produção
- Migrações controladas e versionadas
- Fácil replicação de ambiente

### Negativas
- Necessidade de manter compatibilidade entre H2 e PostgreSQL
- Overhead de configuração do Flyway
- Possíveis diferenças de comportamento entre ambientes

## Alternativas Consideradas

1. **MySQL**
   - Prós: Mais simples de configurar
   - Contras: Menos recursos avançados

2. **MongoDB**
   - Prós: Flexibilidade no esquema
   - Contras: Não adequado para dados relacionais

3. **Liquibase**
   - Prós: Mais flexível que Flyway
   - Contras: Mais complexo de configurar 