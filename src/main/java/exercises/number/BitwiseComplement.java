package exercises.number;

public class BitwiseComplement {
    public int bitwiseComplement(int N) {
        String str = bitwiseComplement( N, "" );
        return str.length() == 0 ? 1 : Integer.parseInt(str,2);
    }

    private String bitwiseComplement(int n, String s) {
        if (n == 0) {
            return s;
        } else {
            int value = n % 2;
            String newS = (value == 0 ? "1" : "0") + s;
            return bitwiseComplement( n / 2, newS );
        }
    }
}
