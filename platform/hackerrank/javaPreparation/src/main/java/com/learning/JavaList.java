package com.learning;

import static java.util.Arrays.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class JavaList {

  static String inputFilePath = "/javaListInput.txt";

  private static String command;
  private static String indexValueLine;
  private static int index;
  private static String value;

  private static void fileInputExecution() {
    try (
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(JavaList.class.getResourceAsStream(inputFilePath))
      )
    ) {
      Integer.parseInt(reader.readLine());
      String listLine = reader.readLine();
      List<String> list = stream(listLine.split(" "))
        .collect(Collectors.toList());

      int querySize = Integer.parseInt(reader.readLine());
      for (int i = 0; i < querySize; i++) {
        readInput(reader);
        executeCommands(list);
      }
      printResult(list);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private static void scanInput(Scanner scanner) {
    command = scanner.nextLine();
    indexValueLine = scanner.nextLine();
    String[] indexValueArray = indexValueLine.split(" ");

    if (indexValueArray.length > 1) {
      index = Integer.parseInt(indexValueArray[0]);
      value = indexValueLine.split(" ")[1];
    } else {
      index = Integer.parseInt(indexValueArray[0]);
    }
  }

  private static void readInput(BufferedReader reader) throws IOException {
    command = reader.readLine();
    indexValueLine = reader.readLine();
    String[] indexValueArray = indexValueLine.split(" ");

    if (indexValueArray.length > 1) {
      index = Integer.parseInt(indexValueArray[0]);
      value = indexValueLine.split(" ")[1];
    } else {
      index = Integer.parseInt(indexValueArray[0]);
    }
  }

  private static void executeCommands(List<String> list) {
    switch (command) {
      case "Insert":
        list.add(index, value);
        break;
      case "Delete":
        list.remove(index);
        break;
    }
  }

  private static void printResult(List<String> list) {
    String result = String.join(" ", list);
    System.out.println(result);
  }

  public static void main(String[] args) {
    systemInputExecution();
  }

  private static void systemInputExecution() {
    try (Scanner scanner = new Scanner(System.in);) {
      // scan the first line wich contains the size of the list (unused)
      Integer.parseInt(scanner.nextLine());
      String listLine = scanner.nextLine();
      List<String> list = stream(listLine.split(" "))
        .collect(Collectors.toList());
      int querySize = Integer.parseInt(scanner.nextLine());

      for (int i = 0; i < querySize; i++) {
        scanInput(scanner);
        executeCommands(list);
      }
      printResult(list);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
