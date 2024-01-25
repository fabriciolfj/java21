# Java 21

## threads virtuais
- uma thread work (so) pode executar várias threads virtuais
- as threads virtuais são gerenciadas pela jvm
- as threads virtuais, quando ocorrem um bloqueio são desmontadas da thread transportador e o código executado aguarda. Quando ela torna-se disponivel, a thread transportador a restaura continuando o procedimento

### Alguns problemas com uso de threads virtuais
- bibliotecas não adequadas para uso de threads virtuais
- fixação, a thread executou algum código nativo e não pode ser armazenado no headp, ou seja, não consegui ser desmontada da thead transportadora, impedindo que esta execute outras threads
- monopolização, quando a thread virtual executa um procedimento muito long

## scoped value
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
como uma única unidade de trabalho. Tratar todos esses threads filhos como uma única unidade 
ajudará no gerenciamento de todos os threads como uma unidade; assim, o cancelamento e o 
tratamento de erros podem ser feitos de forma mais confiável.

No código multithread estruturado, se uma tarefa for dividida em subtarefas simultâneas, 
todas elas retornarão ao mesmo lugar, ou seja, o bloco de código da tarefa. 
Dessa forma, o tempo de vida de uma subtarefa simultânea fica confinado a esse bloco sintático.
```
- existem alguns tipos de scopo, como:
  - StructuredTaskScope.ShutdownOnFailure() -> desliga as outras threads, caso seu trabalha não tenha sido concluído, caso alguma falhe
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
afirmando que objetos jovens tendem a morrer jovens, enquanto objetos velhos tendem a permanecer por perto. 
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
