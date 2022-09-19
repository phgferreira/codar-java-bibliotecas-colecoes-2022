# java-bibliotecas-colecoes-2022
Conteúdo e desafio do módulo Back-end - Java: bibliotecas e coleções do Movimento Codar 2022

>Status: Em Desenvolvimeto

## Execução do desafio
- Menu Principal:
  - [x] Acessar os menus
- Menu Candidatar-se:
  - [x] Ler perguntas do arquivo formulario.txt
  - [x] Recebe resposta;
  - [x] Passa para a próxima pergunta;
  - [X] Limitar candidatura para pessoas acima dos 16 anos;
  - [x] No final do questionários salvar respostas em arquivo.
- Menu Adicionar pergunta ao formulário:
  - [x] Receber nova pergunta;
  - [x] Salvar no arquivo formulario.txt;
  - [x] Impedir duplicidade de perguntas.
- Menu Remover pergunta do formulário:
  - [x] Receber indentificador da pergunta que deve ser removida do formulario.txt;
  - [x] Impedir remoção das perguntas 1 a 4.
- Menu Listar Formulários Cadastrados:
  - [x] Receber opção de submenu:
    - [x] listar nomes agrupados por idade;
    - [ ] listar quantidade de candidatos por idade;
- Menu Validar Formulários:
  - [ ] Procurar formulários duplicados e exibir em tela;
  - [ ] (Opcional) Pergunta se deseja remover duplicidade escolhendo um cadastro para ser mantido.
- Menu Pesquisar Formulários Cadastrados:
  - [ ] Recebe opção de consulta (nome ou email);
  - [ ] Procura formulários e exibe em tela;
  - [ ] (Opcional) Permite escolher mais opções de consulta.

---

## Desafio

O seu desafio é criar um formulário de pesquisa virtual de inscrição do Movimento Codar:

Crie um programa com um menu com as seguintes opções:

- Candidatar-se
- Adicionar pergunta ao formulário
- Remover pergunta do formulário
- Listar formulários cadastrados
- Pesquisar formulários cadastrados
- Validar formulários
- Sair

### Menu Candidatar-se

O usuário irá responder as perguntas e conforme ele responde uma pergunta a próxima deve ser exibida. As perguntas do formulário devem estar previamente cadastradas num TXT chamado formulario.txt que deve ser criado dentro do projeto.

O TXT deve seguir o padrão abaixo:

P1|Qual o seu nome completo?<br/>
P2|Qual seu e-mail?<br/>
P3|Qual sua idade?<br/>
P4|Qual seu whatsapp ou celular?<br/>
  
  A idade permitida pelo formulário deve ser de no mínimo 16 anos. Caso a idade esteja abaixo do permitido deve ser exibida uma mensagem agradecendo o usuário e pedindo para ele tentar a inscrição novamente quando chegar na idade permitida.
  
- Quando o usuário terminar de responder as perguntas o formulário dele deve ser salvo no formato TXT com o nome do arquivo no padrão {numeroDoFormulario}-{nomeDoCandidato}.txt dentro de uma pasta da sua escolha dentro em seu sistema operacional.
- O nome do arquivo deve ser salvo em letras maíusculas sem acentos e sem espaços para evitar problemas de encoding quando rodar em sistemas operacionais diferentes.

Dica: ao salvar os formulários no mesmo diretório você consegue saber qual o último número de formulário salvo

### Menu Adicionar pergunta ao formulário

Como informado deve possibilitar o usuário adicionar uma nova pergunta ao formulário e salvar o txt formulario.txt com essa alteração.
Ao criar a mesma pergunta novamente o sistema não deve duplicar a pergunta dentro do txt e deve manter apenas uma.

### Menu Remover pergunta do formulário

Como informado deve possibilitar o usuário remover uma pergunta do formulário e salvar o txt formulario.txt com essa alteração.

- Não deve ser possível apagar as perguntas de 1 a 4 pois elas são padrão e não podem ser removidas

### Menu Listar Formulários Cadastrados

O programa deve ter uma opção dentro desse menu que permita o administrador listar os nomes dos candidatos cadastrados agrupados por idade para fins de análise.
Também deve existir uma outra opção que exiba a quantidade de candidatos por idade

### Menu Validar Formulários

O programa deve ter uma funcionalidade que permita o administrador encontrar formulários duplicados e apresentá-los em tela. Um nome duplicado pode ser um homônimo, porém um e-mail + nome iguais com certeza indica uma duplicidade.

Dica: Salve o formulário do candidato no txt com uma estrutura que permita você realizar a varredura buscando se o email informado já existe.

### Menu Pesquisar Formulários Cadastrados

O programa deve permitir realizar a busca se um candidato está cadastrado nos formulários existentes. Lembre-se que o que define a unicidade de um cadastro no seu sistema é o nome do candidato + email.


### Outras regras

As classes devem estar divididas em pacotes. As classes que manipulam os arquivos devem ser acessadas apenas por uma outra classe que forneça as funcionalidades para o menu principal.

Cuidado com os padrões camelCase do java. Respeite a padronização.

Pense numa modelagem flexível e nas boas práticas de codificação e clean code.

Ao finalizar a ação de uma das opções dos menus o usuário deve ser enviado para o menu principal
