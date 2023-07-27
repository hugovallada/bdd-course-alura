# language: pt

@leilao
Funcionalidade: Cadastrando um leilao

  Contexto: # Serve como um before, é o primeiro a ser executado para todos os cenarios
    Dado um usuario logado

  Cenario: Um usuario logado pode cadastrar um leilao
    Quando acessa a pagina de novo leilao
    E preenche o formulario com dados validos
    Então volta para a pagina de leiloes
    E o novo leilao aparece na tabela