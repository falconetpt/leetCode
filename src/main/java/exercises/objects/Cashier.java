package exercises.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Cashier {
    private static int SALES = 0;
    private int n;
    private int discont;
    private Map<Integer, Integer> productPrices;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discont = discount;
        productPrices = new HashMap<>(  );
        IntStream.range( 0, products.length ).forEach( i -> productPrices.put( products[i], prices[i] ) );
    }

    public double getBill(int[] product, int[] amount) {
        int newDiscount = (n + 1) % n == 0 ? discont : 0;
        int cost =  IntStream.range( 0,  product.length).boxed()
                .map( i -> productPrices.getOrDefault( product[i], 0 ) * amount[i] )
                .reduce( 0, Integer::sum );
        SALES++;

        return cost * (cost * discont) / 100.00;
    }
}
