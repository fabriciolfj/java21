# Java 21

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