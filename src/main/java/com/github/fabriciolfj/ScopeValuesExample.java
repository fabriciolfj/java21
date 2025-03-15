package com.github.fabriciolfj;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Importações para a API de Scope Values
//import jdk.incubator.concurrent.ScopeLocal;
//import jdk.incubator.concurrent.StructuredTaskScope;

/**
 * Exemplo de uso de Scope Values em Java (a partir do Java 21)
 *
 * Para executar este código, você precisará:
 * 1. Java 21 ou superior
 * 2. Habilitar o módulo incubador: --add-modules jdk.incubator.concurrent
 * 3. Habilitar o preview: --enable-preview
 */
/*
public class ScopeValuesExample {

    // Definição dos ScopeValues que queremos usar em nossa aplicação
    private static final ScopeLocal<String> REQUEST_ID = ScopeLocal.newInstance();
    private static final ScopeLocal<String> USER_ID = ScopeLocal.newInstance();
    private static final ScopeLocal<Boolean> IS_ADMIN = ScopeLocal.newInstance();

    public static void main(String[] args) throws Exception {
        // Simula o processamento de uma requisição web
        processarRequisicaoWeb();
    }

    private static void processarRequisicaoWeb() throws Exception {
        // Valores que normalmente viriam de uma requisição HTTP
        String requestId = UUID.randomUUID().toString();
        String userId = "user123";
        boolean isAdmin = true;

        // Definindo os valores no escopo atual e executando o código
        ScopeLocal.where(REQUEST_ID, requestId)
                .where(USER_ID, userId)
                .where(IS_ADMIN, isAdmin)
                .run(() -> {
                    try {
                        System.out.println("Iniciando processamento da requisição");
                        processarRequisicao();
                    } catch (Exception e) {
                        System.err.println("Erro no processamento: " + e.getMessage());
                    }
                });
    }

    private static void processarRequisicao() throws Exception {
        // Observe que não recebemos os valores como parâmetros
        System.out.println("Processando requisição: " + REQUEST_ID.get());
        System.out.println("Usuário: " + USER_ID.get());

        // Verificação de autorização sem passar contexto explicitamente
        if (IS_ADMIN.get()) {
            System.out.println("Usuário com permissões administrativas");
        }

        // Os valores de escopo são propagados automaticamente para métodos chamados
        buscarDadosNoDatabase();

        // Também são propagados para threads criadas dentro do escopo
        try (var scope = new StructuredTaskScope<Void>()) {
            scope.fork(() -> {
                processarTarefaAssincrona();
                return null;
            });

            scope.join();
        }
    }

    private static void buscarDadosNoDatabase() {
        // Os valores de escopo estão disponíveis em qualquer profundidade da pilha de chamadas
        System.out.println("Buscando dados para requisição: " + REQUEST_ID.get());
        System.out.println("Registrando acesso do usuário: " + USER_ID.get());

        // Simulação de uma operação de banco de dados
        System.out.println("Dados recuperados com sucesso");
    }

    private static void processarTarefaAssincrona() {
        // Os valores de escopo são propagados para esta thread
        System.out.println("Tarefa assíncrona para requisição: " + REQUEST_ID.get());
        System.out.println("Processando em background para usuário: " + USER_ID.get());

        // Realiza operações assíncronas mantendo o contexto
        System.out.println("Processamento assíncrono concluído");
    }

    // Exemplo de uso com ExecutorService (com ScopeLocal carrier)
    private static void exemploComExecutorService() throws Exception {
        String requestId = UUID.randomUUID().toString();

        ScopeLocal.where(REQUEST_ID, requestId).run(() -> {
            try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
                // Com as virtual threads, a propagação do contexto é automática
                executor.submit(() -> {
                    // O requestId está disponível aqui mesmo em outro thread
                    System.out.println("Thread executora: " + REQUEST_ID.get());
                    return null;
                }).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}*/