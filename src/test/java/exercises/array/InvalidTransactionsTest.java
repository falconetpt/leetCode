package exercises.array;

import org.junit.jupiter.api.Test;

import java.util.List;

class InvalidTransactionsTest {
    private InvalidTransactions i = new InvalidTransactions();

    @Test
    void invalidTransactions() {
        List<String> result = i.invalidTransactions( new String[] {
                "bob,689,1910,barcelona",
                "alex,696,122,bangkok",
                "bob,832,1726,barcelona",
                "bob,820,596,bangkok",
                "chalicefy,217,669,barcelona",
                "bob,175,221,amsterdam"
        } );

    }
}