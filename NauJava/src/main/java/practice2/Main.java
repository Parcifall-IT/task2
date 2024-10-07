package practice2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                Task1.Task();
                break;
            case 2:
                Task2.Task();
                break;
            case 3:
                Task3.Task();
                break;
            case 4:
                Task4.Task();
                break;
            case 5:
                Task5 task = new Task5(
                        "src/test/files/first",
                        "src/test/files/second",
                        "src/test/files/result",
                        's');
                task.Start();
                break;
            default:
                break;
        }
    }
}
