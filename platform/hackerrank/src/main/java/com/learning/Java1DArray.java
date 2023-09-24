package com.learning;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Java1DArray {

  public static boolean canWin(int leap, int[] game, int index) {
    if (index < 0 || index >= game.length || game[index] == 1) {
      return false;
    }
    if (index == game.length - 1 || index + leap >= game.length) {
      return true;
    }
    game[index] = 1;

    return (
      canWin(leap, game, index + 1) ||
      canWin(leap, game, index - 1) ||
      canWin(leap, game, index + leap)
    );
  }

  public static boolean canWin(int[] game, int leap) {
    return canWin(leap, game, 0);
  }

  public static void diffOutputTest(){
    String inputFilePath = "/java1DArray.txt";
    String compareFilePath = "/java1DCompare.txt";
    String outputFilePath = "java1DArray_output.txt";

    try (
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(
          Java1DArray.class.getResourceAsStream(inputFilePath)
        )
      );
      BufferedReader compareReader = new BufferedReader(
        new InputStreamReader(
          Java1DArray.class.getResourceAsStream(compareFilePath)
        )
      );
      FileWriter writer = new FileWriter(outputFilePath);
    ) {
      Integer.parseInt(reader.readLine());

      Stack<String> stack = new Stack<String>();
      String line;
      
      for (int i = 1; (line = reader.readLine()) != null; i++) {
        stack.push(line);

        if (i % 2 == 0) {
          int[] game = Arrays
            .stream(stack.pop().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

          String[] sizeAndLeap = stack.pop().split(" ");
          int leap = Integer.parseInt(sizeAndLeap[1]);

          String result = (canWin(game, leap)) ? "YES" : "NO";
          String compareResult = compareReader.readLine();

          if (!result.equals(compareResult)) {
            System.out.println("WRONG OUTPUT");
          }

          writer.write(result + "\n");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    diffOutputTest();
  }
}
