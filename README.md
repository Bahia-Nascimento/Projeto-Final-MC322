# Projeto-Final-MC322

        O projeto é uma simulação de um modelo virtual de administração de de alunos,
    professores, matéria e turmas. A ideia era criar um sistema em que recebendo alunos 
    e professores previamente cadastrados fosse possivel, adicionar e remover matérias
    dos alunos, criar turmas com professores, visualizar todos os objetos, e permitir
    a geração de um diploma para alunos que já tenham cursado todas as disciplinas.
        A atualização dos alunos, ou seja, a remoção e adição de matérias concluidas,
    foi feita de forma a identificar o curso do aluno, e o movimento de matérias da grade
    para lista de materias concluidas. A atualização de professores foi feita de froma a
    se criar turmas dentro do professor. As funções de visualização geram listas que 
    imprimem todos os dados em tabelas. Por fim, a função de solicitar diploma verifica por
    meio de uma função booleana se a grade está vazia (quando um aluno "conclui uma materia"
    a matéria sai da grade e vai para lista de matérias concluidas) e gera uma mensagem permitindo
    ou não a geração do diploma. As funções solicitam RA(Alunos) e Cadastro(Professores)
    como forma de segurança.
        O maior desafio, que foi a interface gráfica, foi realizada por meio do Javafx,
    que cria as telas por meio de um sistema de VIEW<->CONTROLLER<->MODEL.

# Participantes
>Breno Shigeki Guimarães Nishimoto (220599)
>Gabriel de Carvalho Silva Nascimento (222103)
>Gustavo Souza (171425)
>Mateus da Costa e Silva Rios Alves de Andrade (230806)
