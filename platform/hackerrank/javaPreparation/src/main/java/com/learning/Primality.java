package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Primality {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        boolean isPrime = new BigInteger(n).isProbablePrime(1);
        if (isPrime) {
            System.out.print("prime");
        } else {
            System.out.print("not prime");
        }
        bufferedReader.close();
    }
}