package practice2;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void Task() {
        var scanner = new Scanner(System.in);
        var rand = new Random();
        var n = scanner.nextInt();
        var array = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(0, 1000);
            sum += array[i];
        }
        System.out.println("Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.print("\nMean:\n" + sum / n);
    }
}
