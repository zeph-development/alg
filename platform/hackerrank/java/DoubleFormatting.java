package platform.hackerrank.java;

import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class JavaI {

    private static String formatIndiaPayment(double value) {
        String pattern = "###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        
        String format = decimalFormat.format(value);
        return "Rs." + format;
    }

    private static String formatLocalPayment(Locale locale, double value) {
        if (locale.getLanguage().equals("in")) {
            return formatIndiaPayment(value);
        }

        NumberFormat formater = NumberFormat.getCurrencyInstance(locale);
        return formater.format(value);
    }

    private static void formatPayment() {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us = formatLocalPayment(Locale.US, payment);
        String india = formatLocalPayment(new Locale("IN"), payment);
        String china = formatLocalPayment(Locale.CHINA, payment);
        String france = formatLocalPayment(Locale.FRANCE, payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

    public static void main(String... args) {
        formatPayment();
    }
}