package com.learning;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

//Page: https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true

public class Java2DSubArray {

    private static int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int arraySize = Integer.parseInt(scan.nextLine().trim());

        int[] array = new int[arraySize];

        String line = scan.nextLine();
        String[] arrayLine = line.trim().split(" ");
        scan.close();

        for (int i = 0; i < arraySize; i++) {
            array[i] = Integer.parseInt(arrayLine[i]);
        }
        
        int count = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = i; j < arraySize; j++) {
                if (Arrays.stream(subArray(array, i, j)).sum() < 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
