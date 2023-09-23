package com.learning;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//Page: https://www.hackerrank.com/challenges/java-2d-array/problem?isFullScreen=true

public class Java2DArray {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int[][] h = new int[6][6];
        for (int i=0;i<6;++i)
            for (int j=0;j<6;++j)
                h[i][j] = sc.nextInt();
            
        int m = -10000;
        for (int i=0;i<=3;++i){
            for (int j=0;j<=3;++j){
                int s = h[i][j] + h[i][j+1] + h[i][j+2] + h[i+1][j+1] + h[i+2][j] + h[i+2][j+1] + h[i+2][j+2];
                if (s>m) m=s;
            }
        }
        System.out.println(m);
    }
}
