package com.github.fabriciolfj;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyTest {

    /*
    public static void main(String[] args) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()()) {

            Future<AccountDetails> accountDetailsFuture = scope.fork(() -> getAccountDetails(id));
            Future<LinkedAccounts> linkedAccountsFuture = scope.fork(() -> fetchLinkedAccounts(id));
            Future<DemographicData> userDetailsFuture = scope.fork(() -> fetchUserDetails(id));

            scope.join();	// Join all subtasks
            scope.throwIfFailed(e -> new WebApplicationException(e));

            //The subtasks have completed by now so process the result
            return new Response(accountDetailsFuture.resultNow(),
                    linkedAccountsFuture.resultNow(),
                    userDetailsFuture.resultNow());
        }
    }*/
}
