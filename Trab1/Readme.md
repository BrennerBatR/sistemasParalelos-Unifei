Como exemplo, considere o problema de calcular a soma de uma sequência A de n números.
O algoritmo padrão calcula a soma fazendo uma única passagem pela sequência, mantendo
uma soma contínua dos números vistos até agora. Não é difícil, no entanto, conceber um algoritmo para
calculando a soma que executa muitas operações em paralelo. Por exemplo, suponha que, em
paralelamente, cada elemento de A com um índice par é emparelhado e somado ao próximo elemento de A,
que possui um índice ímpar, ou seja, A [0] é emparelhado com A [1], A [2] com A [3] e assim por diante. O resultado é um
nova sequência de ⌈n / 2⌉ números que somam o mesmo valor que a soma que queremos calcular.
Este passo de emparelhamento e soma pode ser repetido até que, após ⌈log2 e ⌉ passos, uma sequência consistindo em
um único valor é produzido e esse valor é igual à soma final