import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Pudim.findByName( "XPTO" ));
    }

    public static enum Pudim {
        XPTO("S");

        private String xpto;

        Pudim(String xpto) {
            this.xpto = xpto;
        }

        public static String findByName(String xpto) {
            return Arrays.stream(values())
                    .filter( e -> e.toString().equalsIgnoreCase( xpto ) )
                    .map( e -> e.xpto )
                    .findFirst()
                    .orElse( "" );
        }
    }
}
