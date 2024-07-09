# testes-t5
Repositório da disciplina Testes (Turma 5) 

## Atualizando seu repositório local

O código produzido em sala de aula, e compartilhado neste repositório, pode ser atualizado em seu repositório local com o comando:

```console
git pull
```

No entando, se você fez alterações no seu repositório local, o comando acima pode gerar conflitos. Para evitar lidar com isso, você pode forçar uma atualização com o repositório remoto por meio dos comandos:

```console
git fetch origin
git reset --hard origin/main
```

O primeiro comando recebe as atualizações mais recentes do repositório remoto, e o segundo descarta todas as alterações locais e atualiza com o histórico mais recente do repositório remoto (branch main).


## Como inciar a aplicação

### Back-end

```console
cd sgcmapi
mvn package
java -jar target\sgcmapi.jar
```

Ou

```console
cd sgcmapi
mvn spring-boot:run
```

A aplicação vai iniciar no endereço <https://localhost:9000>, com acesso local a base de dados MySQL, por meio da porta padrão 3306, além de usuário e senha "root".

### Front-end

Para iniciar a aplicação, é necessário também instalar as dependências do projeto.

```console
cd sgcmapp
npm install
ng serve
```

A aplicação vai iniciar no endereço <https://localhost:4200>.

## Atividades práticas

> [!IMPORTANT]
>
> - As atividades serão realizadas com o GitHub Classroom e podem ser acessadas pelos links nas descrições das atividades.
> - Link da sala de aula para a disciplina de Testes: https://classroom.github.com/classrooms/101579917-webacademy-ufac-classroom-testes-t5

1. [INDIVIDUAL] Criar uma classe de testes com JUnit para um método de outra classe Java capaz transformar um número em algarismo romano (no formato string) para um inteiro no sistema decimal (até o valor 4000). (Entrega: 02/07/2024). Link da atividade: https://classroom.github.com/a/Rei43Rux

    - Os testes devem incluir algarismos com apenas um algarismo, com algarismos iguais, com algarismos diferenes, com algarismos de notação subtrativa (ex: IV, IX, XIV) e com algarismos inválidos.

2. [INDIVIDUAL] Criar métodos de teste para três métodos da camada de serviço (getAtendimentoById, getAtendimentoTermoBusca e getAtendimentoSave). (Entrega: 04/07/2024). Link da atividade: https://classroom.github.com/a/fCPS5BKN

3. [INDIVIDUAL] Criar métodos de testes integrados para classe de AtendimentoController (ById, TermoBusca, Insert, Update, Delete, UpdateStatus, GetHorarios) e AtendimentoRepository (BuscaPaciente, BuscaConvenio, BuscaUnidade, BuscaEspecialidade, BuscaProfissionalDataStaus). (Entrega: 08/07/2024). Link da atividade: https://classroom.github.com/a/ZB3y_PQJ

4. [GRUPO] Criar testes para o projeto back-end. (Entrega: 09/07/2024). Link da atividade: https://classroom.github.com/a/BmYivnuZ

    - **Back-end**: criar testes de unidade e integração até alcançar o máximo de cobertura de código.
    
5. [GRUPO] Criar testes para o projeto front-end. (Entrega: 10/07/2024). Link da atividade: https://classroom.github.com/a/1ZwC-2Fj

    - **Front-end**: criar testes E2E para validar a funcionalidade de salvar registros nas demais entidades gerenciadas pelo sistema (pacientes, profisisonais, convênios, especialidades, unidades e usuários), de forma semelhante ao teste criado para o agendamento de consultas.