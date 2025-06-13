# História Contada pela Equipe de Análise de Requisitos – API de Cadastro de Alunos

Durante as reuniões iniciais com os stakeholders da instituição, foi identificado um problema recorrente na gestão das informações dos alunos. Professores e o setor da secretaria relataram dificuldades no acesso e na atualização de dados estudantis, bem como na emissão de relatórios e no acompanhamento acadêmico.

Como resposta a essa necessidade, propomos o desenvolvimento da API de Cadastro de Alunos, um sistema centralizado que atuará como ponto único de integração para o cadastro, consulta e manutenção das informações dos alunos da instituição.

## 👤 Atores Principais

- **Professores**: precisam cadastrar, consultar ou atualizar informações dos alunos, especialmente ao início de cada período letivo ou durante eventos específicos (como avaliações e reuniões).

- **Secretaria**: necessita acessar relatórios atualizados para fins administrativos, como emissão de documentos, controle de matrícula, e envio de dados para órgãos reguladores.

## 🔄 Interações com Sistemas Externos

A API se comunica com três componentes externos para fornecer suas funcionalidades:

1. **Banco de Dados**: Todos os dados dos alunos são armazenados de forma estruturada. O sistema realiza operações de leitura e escrita nesse banco de forma segura e eficiente.

2. **Sistema de E-mail**: Sempre que necessário, a API envia notificações automáticas — como confirmação de matrícula, alertas sobre pendências documentais ou comunicados da secretaria.

3. **API de Histórico Escolar**: Para exibir ou validar dados acadêmicos (como notas, frequência e progressão), a API se conecta a um sistema externo especializado nesse tipo de informação.

## 📌 Objetivo Geral da Solução

A API de Cadastro de Alunos visa:

- Centralizar e padronizar o gerenciamento das informações estudantis;
- Reduzir erros manuais e retrabalhos;
- Otimizar a comunicação entre setores (docente e administrativo);
- Promover maior transparência e agilidade na emissão de relatórios e documentos oficiais.

## 🧩 Visão Resumida do Sistema

O sistema funciona como uma ponte entre os usuários finais (professores e secretarias) e os recursos necessários (dados, relatórios, históricos escolares e notificações). Ele é um componente estratégico que permitirá escalabilidade futura, podendo ser integrado com portais acadêmicos, sistemas de gestão educacional e aplicativos mobile. 