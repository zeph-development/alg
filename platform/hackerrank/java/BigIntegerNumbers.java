import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerNumbers {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[2];
        for (int i = 0; i < s.length; i++) {
            s[i] = sc.next();
        }
        sc.close();

        BigInteger sum = new BigInteger(s[0]);
        BigInteger product = new BigInteger(s[0]);
    
        System.out.println(sum.add(new BigInteger(s[1])));
        System.out.println(sum.multiply(new BigInteger(s[1])));
    }
}