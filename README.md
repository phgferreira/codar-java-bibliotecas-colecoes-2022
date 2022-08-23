# java-bibliotecas-colecoes-2022
Conteúdo e desafio do módulo Back-end - Java: bibliotecas e coleções do Movimento Codar 2022

## Desafio

O seu desafio é criar um formulário de pesquisa virtual de inscrição do Movimento Codar:

Crie um programa com um menu com as seguintes opções:

- Candidatar-se
- Adicionar pergunta ao formulário
- Remover pergunta do formulário
- Listar formulários cadastrados

### Menu Candidatar-se

O usuário irá responder as perguntas e conforme ele responde uma pergunta a próxima deve ser exibida. As perguntas do formulário devem estar previamente cadastradas num TXT chamado formulario.txt que deve ser criado dentro do projeto.

O TXT deve seguir o padrão abaixo:

P1|Qual o seu nome completo?
P2|Qual seu e-mail?
P3|Qual sua idade?
P4|Qual seu whatsapp ou celular?
  
  A idade permitida pelo formulário deve ser de no mínimo 16 anos. Caso a idade esteja abaixo do permitido deve ser exibida uma mensagem agradecendo o usuário e pedindo para ele tentar a inscrição novamente quando chegar na idade permitida.
  
- Quando o usuário terminar de responder as perguntas o formulário dele deve ser salvo no formato TXT com o nome do arquivo no padrão {nomeDoCandidato}.txt dentro de uma pasta chamada movimento-codar-2022 que deve ser criada dentro do projeto.
- O nome do arquivo deve ser salvo em letras maíusculas sem acentos e sem espaços para evitar problemas de encoding quando rodar em sistemas operacionais diferentes.
- O programa não deve permitir o cadastro de dois candidatos com o mesmo e-mail e isso deve ser validado durante o cadastro do candidato.

Dica: Salve o formulário do candidato no txt com uma estrutura que permita você realizar a varredura buscando se o email informado já existe.


### Adicionar pergunta ao formulário

Como informado deve possibilitar o usuário adicionar uma nova pergunta ao formulário e salvar o txt formulario.txt com essa alteração.
Ao criar a mesma pergunta novamente o sistema não deve duplicar a pergunta dentro do txt e deve manter apenas uma.

### Remover pergunta do formulário

Como informado deve possibilitar o usuário remover uma pergunta do formulário e salvar o txt formulario.txt com essa alteração.

- Não deve ser possível apagar as perguntas de 1 a 4 pois elas são padrão e não podem ser removidas

### Outras regras

Deve ser possível voltar para o menu principal sempre que o usuário quiser digitando uma opção no console.

As classes devem estar divididas em pacotes. As classes que manipulam os arquivos devem ser acessadas apenas por uma outra classe que forneça as funcionalidades para o menu principal.

Cuidado com os padrões camelCase do java. Respeite a padronização.




