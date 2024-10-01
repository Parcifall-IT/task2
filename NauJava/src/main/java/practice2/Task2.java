package practice2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var rand = new Random();
        var n = scanner.nextInt();
        var numbers = new ArrayList<Double>();
        for (int i = 0; i < n; i++) {
            numbers.add(rand.nextDouble(0, 1000));
        }
        System.out.println("Original List:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f \t", numbers.get(i));
        }
        System.out.println("\nSorted List:");
        BubbleSort(numbers);
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f \t", numbers.get(i));
        }
    }

    public static void BubbleSort(ArrayList<Double> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j + 1) < array.get(j)) {
                    var swap = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, swap);
                }
            }
        }
    }
}
