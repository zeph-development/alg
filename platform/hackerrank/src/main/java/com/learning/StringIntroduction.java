package com.learning;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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

        for (int i = 1; i < s.length() - k + 1; i++) {
            String substr = s.substring(i, i + k);
            if (smallest.compareTo(substr) > 0)
                smallest = substr;
            if (largest.compareTo(substr) < 0)
                largest = substr;
        }

        return smallest + "\n" + largest;
    }

    private static boolean isPalindrome() {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int ALength = A.length();
        boolean isPallindrome = true;
        for (int i = 0, j = ALength - 1; i < ALength / 2; i++, j--) {
            if (A.charAt(i) != A.charAt(j)) {
                isPallindrome = false;
            }
        }

        return isPallindrome;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < b.length(); i++) {
            a = a.replaceFirst(String.valueOf(b.charAt(i)), "");
        }

        return a.isEmpty() ? true : false;
    }

    private static void extractTokens() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        s = s.trim();
        if (s == null || s.isEmpty()) {
            System.out.print(0);
            return;
        }

        s = s.replaceAll("[\\!\\?\\,\\.\\_\\'\\@]", " ");

        String[] tokens = s.split(" +");

        System.out.println(tokens.length);
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    private static void compilePattern() {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        while (testCases-- > 0) {
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
                continue;
            }
            System.out.println("Valid");
        }
    }

    static class MyRegex {
        final String pattern = "^(([0-9]|[1-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        public MyRegex() {
        }
    }

    private static void regexMatchIp() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

    private static void repeadedWords() {
        String regex = "(\\b\\w+\\b)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher match = p.matcher(input);

            while (match.find()) {
                input = input.replaceAll(match.group(), match.group(1));
            }

            System.out.println(input);
        }

        in.close();
    }

    private static class Solution {
        private static final Scanner scan = new Scanner(System.in);

        public static void main(String[] args) {
            int n = Integer.parseInt(scan.nextLine());
            while (n-- != 0) {
                String userName = scan.nextLine();

                if (userName.matches(UsernameValidator.regularExpression)) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            }
        }
    }

    private static class UsernameValidator {
        public static final String regularExpression = "";
    }

    private static void usernameChecker() {
        final Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }

    private static void innerHtmlTagsContent() {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        // int testCases = 1;

        String regex = "<([^>]+)>([^<>]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        
        while (testCases > 0) {
            String line = in.nextLine();
            
            Matcher matcher = pattern.matcher(line);
            boolean findMatch = true;
            
            while(matcher.find()){
                System.out.println(matcher.group(2));
                findMatch = false;
            } 
            if(findMatch) {
                System.out.println("None");
            }
            testCases--;
        }
    }

    public static void main(String... args) {

        // compareStrings();
        // subString();
        // System.out.println(subStringOrder("welcomeToJava", 3));
        // System.out.println(isPalindrome());
        // System.out.println(isAnagram("acb", "BaC"));
        // extractTokens();
        // compilePattern();
        // regexMatchIp();
        // repeadedWords();

        innerHtmlTagsContent();
        
    }
}