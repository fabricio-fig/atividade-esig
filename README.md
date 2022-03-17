# atividade-esig

Projeto feito em Java com as tecnologias Hibernate, JPA, JSF, Pimefaces e banco de dados Postgres.


*Instruções de como usar o projeto*

1 - Ter o JRE(Java Runtime Enviroment) e o PostgreSQL instalados em seu computador.

2 - Baixar o aquivo .zip e descompactá-lo em sua pasta de projetos.

3 - Criar um banco com o nome de sua preferência no PostgreSQL, dentro desse bancco é necessário criar uma tabela para armazenas a lista de tarefas, 
a tabela deve ter as colunas com os respectivos nomes 'numero' - 'deadline' - 'descricao' - 'prioridade' - 'responsavel' - 'titulo'. Sendo que a coluna 
'numero' deve ser criada como serial e chave primária, pois servirá como ID.

![Captura de tela em 2022-03-16 22-09-33](https://user-images.githubusercontent.com/59463323/158718165-275f8148-4e3e-4909-bc0f-97b3c3f97743.png)

4 - Uma vez com o projeto importado no Exclipse é necessário configurar o aquivo persistence.xml com as informações do banco, aqui devem ser preenchidos 
o nome do banco que foi criado no PostgreSQL bem como também o nome do ususário do banco e a senha.

![persistenceXML](https://user-images.githubusercontent.com/59463323/158718538-a95fcdf0-58f1-4ff4-b274-536c9bdddd3b.png)

5 - Depois de seguir esses passos é só rodar o projeto num servidor apache, o resultado final poderá ser visualizado ao acessar o link 
'http://localhost:8080/projetoEsig/pagina/Tarefa.xhtml

![Captura de tela em 2022-03-16 22-31-31](https://user-images.githubusercontent.com/59463323/158718678-d9926b84-6506-44de-afa8-7c44e8e1df19.png)

6 - O projeto consiste num CRUD(Create, Read, Update e Delete) simples, está concentrado numa única página com um formulário para cadastro de tarefas,
logo abaixo tem uma tabela dinâmica que atualiza os registro à medida que são feitos os cadastros, ao lado de cada linha descritiva da tarefa tem 
dois botões com ação de edição e exclusão dos registros. 
