# language: pt

Funcionalidade: : Propondo lances

  Cenario: : Propondo um único lance válido
    Dado um lance válido
    Quando propoe o lance ao leilão
    Então o lance é aceito


  Cenario: Propondo vários lances válidos
    Dado um lance de 10.0 reais do usuário "fulano"
    E um lance de 15.0 reais do usuário "beltrano"
    Quando propões ao leilão
    Então os lances são aceitos


  Esquema do Cenário: : Propondo um lance invalido
    Dado um lance invalido de <valor> reais
    Quando propoe ao leilao
    Entao o lance nao e aceito

    Cenarios:
      | valor |
      | -3     |
      | -1    |

  Cenario: Propondo uma sequencia de lances
    Dado dois lances
      | valor | nomeUsuario |
      | 10.0  | beltrano    |
      | 15.0  | beltrano    |
    Quando propoe varios lances ao leilao
    Então o seguindo lance não é aceito
