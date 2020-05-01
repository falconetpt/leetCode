package exercises.array;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        Map<Point, Integer> cache = new HashMap<>(  );

        return IntStream.range( 0, nums.length ).boxed()
                .flatMap( x ->
                        IntStream.range( x, nums.length )
                                .boxed()
                                .map( y -> new Point( nums[x], nums[y] ) )
                )
                .map( p -> hammingDistance(p, cache) )
                .reduce( 0, Integer::sum );
    }

    private Integer hammingDistance(Point p, Map<Point, Integer> cache) {
        if (cache.containsKey( p )) {
            return cache.get( p );
        } else {
            if(p.x == p.y) {
                return 0;
            } else {
                int result = binaryDiference(convertToBinary( p.x ), convertToBinary( p.y ));
                cache.put( p,  result);
                return result;
            }
        }
    }

    private int binaryDiference(String num1, String num2) {
        if (num1.isEmpty() && num2.isEmpty()) {
            return 0;
        } else if (num1.isEmpty() || num2.isEmpty()) {
            return 1 + (
                    num2.isEmpty()
                        ? binaryDiference( num1.substring( 0, num1.length() - 1 ), num2 )
                        : binaryDiference( num1, num2.substring( 0, num2.length() -1 ) )
            );
        } else {
            int result = binaryDiference(
                    num1.substring( 0, num1.length() - 1 ),
                    num2.substring( 0, num2.length() -1 )
            );

            return result + (num1.charAt( num1.length() - 1 ) == num2.charAt( num2.length() - 1 ) ? 0 : 1);
        }
    }

    private String convertToBinary(int num) {
        if (num == 0) {
            return "";
        } else {
            return convertToBinary( num / 2 ) + num % 2;
        }
    }


}
