import java.util.Scanner;

//Page: https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true

public class JavaArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dataRowNumber = Integer.parseInt(scanner.nextLine());

        String[] dataArray = new String[dataRowNumber];
        for (int i = 0; i < dataRowNumber; i++) {
            dataArray[i] = scanner.nextLine();
        }

        int commandRowNumber = Integer.parseInt(scanner.nextLine());
        String[] output = new String[commandRowNumber];
        for (int i = 0; i < commandRowNumber; i++) {
            try {
                String[] commandLine = scanner.nextLine().split(" ");
                String dataLine = dataArray[Integer.parseInt(commandLine[0]) - 1];
                String number = dataLine.split(" ")[Integer.parseInt(commandLine[1])];

                output[i] = number;
            } catch (Exception e) {
                output[i] = "ERROR!";
            }
        }

        for (String line : output) {
            System.out.println(line);
        }
    }
}