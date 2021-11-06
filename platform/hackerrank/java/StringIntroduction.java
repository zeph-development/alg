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

    public static void main(String... args) {
        // compareStrings();
        subString();
    }
}