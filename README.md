# algoritmo-genetico-gerador-palavras

O presente programa gera a partir de um dado número de sete dígitos vinte possiveis combinações de palavras a partir das letras referêntes 
a estes números no teclado da aplicação.


O presente algoritmo foi desenvolvido em JAVA e faz uso (ainda que superficial) de técnicas conhecidas no desenvolvimento de algoritmos genéticos.
A partir de um número com sete dígitos, o programa seleciona as letras referentes a cada dígito gerando em seguida uma População Inicial contendo 10000 palavras, onde cada letra da Nova Palavra é escolhida de forma aleatória junto ao conjunto de letras referentes ao dígito de mesma posição à letra da Nova Palavra.
Tomando por base a formação básica das palavras em Português, fora criado um meio de qualificar (Aptidão) a formação das palavras.
Tendo em mãos a população inicial, realizou-se uma seleção tomando-se por base uma nota de corte onde as palavras ‘menos aptas’ foram descartadas.
Em seguida são realizadas seções de Crossovers, mutações e novas seleções das populações geradas por um número fixo de “gerações”.
Por fim, os dados gerados foram tratados para evitar a presença de palavras repetidas e em ordem de Adaptação.
É interessante destacar que a população inicial é criada com 10000 palavras, onde dependendo da variedade do número inicialmente digitado cerca de 0,3% das palavras tinha aptidão maior ou igual a 70. Já apôs utilização das técnicas descritas esse número chegou a 30%."
