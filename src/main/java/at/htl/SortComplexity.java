package at.htl;

import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountArrays = 0;
        int amountNumbers = 0;
        int sum = 0;

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        amountArrays = scanner.nextInt();

        System.out.print("Größe der Arrays: ");
        amountNumbers = scanner.nextInt();

        for (int i = 1; i <= amountArrays; i++) {
            System.out.printf("%nLaufzeit zur Sortierung des %d. Arrays: %d ms", i, sortRandomArray(amountNumbers));
            sum +=sortRandomArray(amountNumbers);
        }
        System.out.printf("%n%nDurchschnittliche Laufzeit: %d ms", sum / amountArrays);

    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        long timeBefore = System.currentTimeMillis();
        sort(generateRandomArray(length));
        long timeAfter = System.currentTimeMillis();

        return timeAfter - timeBefore;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * 1000) + 1;
        }
        return randomArray;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            int j = i;
            while(j > 0 && (array[j - 1] > k)){
                swap(array, j, j - 1);
                j--;
            }
            array[j] = k;

        }
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        array[i] = array[j];
    }
}
