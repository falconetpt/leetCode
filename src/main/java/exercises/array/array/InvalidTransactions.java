package exercises.array.array;

import java.util.*;
import java.util.stream.Collectors;

public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        LinkedList<Transaction> elements = Arrays.stream(transactions)
                .map( s -> s.split( "," ) )
                .map( a -> new Transaction( a[0], a[1], a[2], a[3] ) )
                .sorted( Comparator.comparingInt( a -> a.time ) )
                .collect( Collectors.toCollection(LinkedList::new));

        Map<String, List<Transaction>> map = new HashMap<>(  );
        elements.forEach( t -> {
            map.putIfAbsent( t.name, new ArrayList<>(  ) );
            map.get( t.name ).add( t );
        } );

        return invalidTransactions( elements, map, new LinkedList<>(  ) );
    }

    private List<String> invalidTransactions(LinkedList<Transaction> elements,
                                             Map<String, List<Transaction>> map,
                                             List<String> result) {
        if (elements.isEmpty()) {
            return result;
        } else {
            Transaction next = elements.pollFirst();
            boolean colidingTransaction = map.get( next.name ).stream()
                    .filter( t -> !next.city.equals( t.city ) )
                    .anyMatch( t -> Math.abs( t.time - next.time ) <= 60 );

            if (next.amount > 1000) {
                result.add( next.toString() );
            } else if (colidingTransaction) {
                result.add( next.toString() );
            }

            return invalidTransactions( elements, map, result );
        }
    }

    public class Transaction {
        private String name;
        private int time;
        private int amount;
        private String city;

        public Transaction(String name, String time, String amount, String city) {
            this.name = name;
            this.time = Integer.valueOf( time );
            this.amount = Integer.valueOf( amount );
            this.city = city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Transaction that = (Transaction) o;
            return time == that.time &&
                    amount == that.amount &&
                    Objects.equals( name, that.name ) &&
                    Objects.equals( city, that.city );
        }

        @Override
        public int hashCode() {
            return Objects.hash( name, time, amount, city );
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }

    /**
     * https://leetcode.com/problems/invalid-transactions/
     *
     * A transaction is possibly invalid if:
     *
     * the amount exceeds $1000, or;
     * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
     * Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.
     *
     * Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
     * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
     * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
     * Example 2:
     *
     * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
     * Output: ["alice,50,1200,mtv"]
     * Example 3:
     *
     * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
     * Output: ["bob,50,1200,mtv"]
     *
     *
     * Constraints:
     *
     * transactions.length <= 1000
     * Each transactions[i] takes the form "{name},{time},{amount},{city}"
     * Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
     * Each {time} consist of digits, and represent an integer between 0 and 1000.
     * Each {amount} consist of digits, and represent an integer between 0 and 2000.
     */

}
