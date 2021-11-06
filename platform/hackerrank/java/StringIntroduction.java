import java.util.Scanner;

public class StringIntroduction {

    private static void compareStrings() {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());

        String secondPointResponse = A.compareTo(B) > 0 ? "Yes" : "No";
        System.out.println(secondPointResponse);

        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase()
                + B.substring(1));
    }

    private static void subString() {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        System.out.println(S.substring(start, end));
    }

    private static String subStringOrder(String s, int k) {
        String smallest = "";
        String largest = "";
        smallest = largest = s.substring(0, k);

        for (int i=1; i<s.length()-k+1; i++) {
            String substr = s.substring(i, i+k);
            if (smallest.compareTo(substr) > 0)
                smallest = substr;
            if (largest.compareTo(substr) < 0)
                largest = substr;
        }

        return smallest + "\n" + largest;
    }

    public static void main(String... args) {
        // compareStrings();
        // subString();

        System.out.println(subStringOrder("welcomeToJava", 3));
    
    }
}