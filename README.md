# Java 21

## threads virtuais
- uma thread work (so) pode executar várias threads virtuais
- as threads virtuais são gerenciadas pela jvm
- as threads virtuais, quando ocorrem um bloqueio são desmontadas da thread transportador e o código executado aguarda. Quando ela torna-se disponivel, a thread transportador a restaura continuando o procedimento

### Alguns problemas com uso de threads virtuais
- bibliotecas não adequadas para uso de threads virtuais
- fixação, a thread executou algum código nativo e não pode ser armazenado no heap, ou seja, não consegui ser desmontada da thead transportadora, impedindo que esta execute outras threads
- monopolização, quando a thread virtual executa um procedimento muito longo

## scoped value (substituto para threadlocal em threasvirtuais)
```
Se você estiver familiarizado com variáveis 
ThreadLocal , os valores com escopo definido são uma maneira moderna de compartilhar dados 
dentro e entre threads . Os valores com escopo permitem que um valor (objeto) seja 
armazenado por um tempo limitado, de forma que apenas o thread que escreveu o valor possa lê-lo.
``` 

## Structure concurrency
```
O recurso de simultaneidade estruturada visa simplificar os programas simultâneos Java, 
tratando múltiplas tarefas executadas em threads diferentes (bifurcadas do mesmo thread pai) 
como uma única unidade de trabalho. Tratar todas essas threads filhas como uma única unidade 
ajudará no gerenciamento; assim o cancelamento ou
tratamento de erros podem ser feitos de forma mais confiável.

No código multithread estruturado, se uma tarefa for dividida em subtarefas simultâneas, 
todas elas retornarão ao mesmo lugar, ou seja, o bloco de código da tarefa. 
Dessa forma, o tempo de vida de uma subtarefa simultânea fica confinado a esse bloco sintático.
```
- existem alguns tipos de scopo, como:
  - StructuredTaskScope.ShutdownOnFailure() -> desliga as outras threads, caso seu trabalho não tenha sido concluído, caso alguma falhe
  - StructuredTaskScope.ShutdownOnSuccess() -> caso alguma thread retorne com sucesso (a primeira no caso), as demais são desligadas
  - handleComplete() podemos também personalizar

## HotSpot JVM 
- é o mecanismo de tempo de execução desenvolvido pela Oracle. Ele traduz o bytecode Java em código de máquina para a arquitetura do processador do sistema operacional host.

## JEP 439: ZGC Geracional
```
O Z Garbage Collector (ZGC) é um coletor de lixo escalável e de baixa latência. 
Ele está disponível para uso em produção desde Java 15 e foi projetado para manter tempos de pausa consistentes e curtos, mesmo para heaps muito grandes. 
Ele usa técnicas como gerenciamento e compactação de memória baseados em região para conseguir isso.
Java 21 introduz uma extensão ao ZGC que mantém gerações separadas para objetos novos e antigos, 
permitindo que o ZGC colete objetos jovens (que tendem a morrer jovens) com mais frequência. 
Isso resultará em um ganho significativo de desempenho para aplicativos executados com ZGC geracional, 
sem sacrificar nenhuma das propriedades valiosas pelas quais o coletor de lixo Z já é conhecido:
  Os tempos de pausa não excedem 1 milissegundo;
  Tamanhos de heap de algumas centenas de megabytes até muitos terabytes são suportados;
  É necessária uma configuração manual mínima.
A razão para lidar separadamente com objetos jovens e velhos decorre da hipótese geracional fraca , 
afirmando que objetos jovens tendem a morrer jovens, enquanto objetos velhos tendem a permanecer por mais tempo. 
Isso significa que a coleta de objetos novos requer menos recursos e produz mais memória, enquanto a coleta de objetos antigos requer mais recursos e produz menos memória. 
Esta é a razão pela qual podemos melhorar o desempenho de aplicações que utilizam ZGC coletando objetos jovens com mais frequência.
O que há de diferente do Java 20?
O coletor de lixo Z no Java 20 só era capaz de se comportar de maneira não geracional. Executá-lo exigiu a seguinte configuração de linha de comando:

$ java -XX:+UseZGC ...

Para executar sua carga de trabalho com o novo Generational ZGC em Java 21, use a seguinte configuração:

$ java -XX:+UseZGC -XX:+ZGenerational ...

Como você pode ver, o ZGC geracional foi introduzido junto com o ZGC não geracional. Em uma versão futura, 
podemos esperar que o ZGC geracional se torne a configuração padrão para o coletor de lixo Z, 
enquanto uma versão ainda posterior provavelmente removerá completamente o ZGC não geracional.
```

# Dicas java

### compra compactar e desocompcatar bytes
- use Deflater/Inflater


### priority queue
```
A `PriorityQueue` (Fila de Prioridade) é uma estrutura de dados que mantém uma coleção de elementos com prioridades associadas. A principal vantagem de uma `PriorityQueue` é que ela permite que os elementos sejam processados com base em sua prioridade, garantindo que o elemento com a maior ou menor prioridade seja o próximo a ser removido da fila.

Aqui estão algumas vantagens e casos de uso comuns para `PriorityQueue`:

1. **Eficiência na Inserção e Remoção:**
   - A `PriorityQueue` é eficiente na inserção e remoção de elementos, especialmente quando comparada a outras estruturas de dados como listas ordenadas. A complexidade de tempo para inserção e remoção é geralmente O(log n), onde "n" é o número de elementos na fila.

2. **Ordenação Automática:**
   - A `PriorityQueue` mantém automaticamente os elementos em ordem com base em suas prioridades. Isso significa que você não precisa se preocupar com a ordenação manual da coleção sempre que um novo elemento é inserido ou um elemento é removido.

3. **Algoritmos Baseados em Prioridade:**
   - É útil em algoritmos que requerem processamento com base em prioridades, como algoritmos de busca de caminho mínimo (por exemplo, Dijkstra) e algoritmos de árvore de spanning mínima (por exemplo, Prim).

4. **Solução para Problemas de Scheduling:**
   - Pode ser utilizado em problemas de escalonamento, onde tarefas precisam ser executadas com base em suas prioridades ou prazos.

5. **Implementação de Algoritmos de Huffman:**
   - A `PriorityQueue` é frequentemente usada na implementação de algoritmos de compressão, como o algoritmo de Huffman, que é usado em compressão de dados.

6. **Soluções para Problemas de Eventos com Prioridade:**
   - Em simulações ou sistemas que lidam com eventos com diferentes prioridades, uma `PriorityQueue` pode ser usada para agendar e processar eventos de forma eficiente.

Lembre-se de que a escolha de usar uma `PriorityQueue` dependerá das características específicas do problema que você está tentando resolver. Se a ordem de processamento com base em prioridades é crucial para o desempenho do seu algoritmo ou sistema, a `PriorityQueue` pode ser uma escolha eficiente e conveniente.
```

### uso countDownLatch e Semaphore
- countDownLatch e um decrementador, onde ele vai decrementando ate chegar a 0. Utilizado para aguardar as outras threads concluirem suas operações, onde cada
- thread executada, decrementa o valor do mesmo. A thread principal chama o await, ate que o decrementador chegue a 0.

- semaphore utilizado para dar permissão a recursos para as threads, concedendo licenças e retirando-as. E mais dinâmico que o countDownLatch, no entanto
- há uma sobrecarga de processamento no processo de concessão.


### Coleções sequenciadas
- Uma coleção sequenciada é essencialmente uma coleção com uma ordem de encontro definida. Cada elemento desta coleção possui uma posição bem definida – primeiro,
- segundo e assim por diante, até o último elemento.
- Os principais recursos incluem:
 - Um método reversed() para fornecer uma visão ordenada inversa da coleção. 
 - Métodos para adicionar, obter e remover elementos em ambas as extremidades da coleção.
 - não há elementos duplicados

### strictfp
- A partir do Java 17, todas as operações de ponto flutuante obedecem às regras do IEEE 754 por padrão, graças à implementação do JEP 306 (Restore Always-Strict Floating-Point Semantics).
- Antes do Java 17, o `strictfp` era necessário para garantir resultados consistentes e previsíveis em cálculos de ponto flutuante, independentemente da arquitetura do processador.

### absExact
- quando um valor negativo, ao deixa-lo absoluto (positivo usando Math.abs) não cabe em um int, o Math.abs mostra um valor enganoso
- devemos usar o Math.absExact, que nessa situação lançaria uma exception ArithmeticException
