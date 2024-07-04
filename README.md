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


## Atividades práticas

> [!IMPORTANT]
>
> - As atividades serão realizadas com o GitHub Classroom e podem ser acessadas pelos links nas descrições das atividades.
> - Link da sala de aula para a disciplina de Testes: https://classroom.github.com/classrooms/101579917-webacademy-ufac-classroom-testes-t5

1. [INDIVIDUAL] Criar uma classe de testes com JUnit para um método de outra classe Java capaz transformar um número em algarismo romano (no formato string) para um inteiro no sistema decimal (até o valor 4000). (Entrega: 02/07/2024). Link da atividade: https://classroom.github.com/a/Rei43Rux

    - Os testes devem incluir algarismos com apenas um algarismo, com algarismos iguais, com algarismos diferenes, com algarismos de notação subtrativa (ex: IV, IX, XIV) e com algarismos inválidos.

2. [INDIVIDUAL] Criar métodos de teste para três métodos da camada de serviço (getAtendimentoById, getAtendimentoTermoBusca e getAtendimentoSave). (Entrega: 04/07/2024). Link da atividade: https://classroom.github.com/a/fCPS5BKN