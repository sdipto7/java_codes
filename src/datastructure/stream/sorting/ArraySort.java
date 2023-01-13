package datastructure.stream.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySort {

    public static void main(String[] args) {
        int[] intArray = new int[]{7, 3, 9, 5, 8, 1, 4, 5};
        Integer[] integerArray = new Integer[]{7, 3, 9, 5, 8, 1, 4, 5};

        System.out.println(Arrays.toString(sortIntArray(intArray)));
        System.out.println(Arrays.toString(sortIntegerArray(integerArray)));

        sortIntArrayByArraysClass(intArray);
        System.out.println(Arrays.toString(intArray));
        sortIntegerArrayByArraysClass(integerArray);
        System.out.println(Arrays.toString(integerArray));
    }

    private static int[] sortIntArray(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }

    private static Integer[] sortIntegerArray(Integer[] array) {
        return Arrays.stream(array)
//                .sorted() // Ascending order sort
//                .sorted(Integer::compareTo) // Ascending order sort
//                .sorted(Collections.reverseOrder()) // Descending order sort
                .sorted(Comparator.comparing(Integer::intValue, Collections.reverseOrder())) // Descending order sort
                .toArray(Integer[]::new);
    }

    private static void sortIntArrayByArraysClass(int[] array) {
        Arrays.sort(array);
    }

    private static void sortIntegerArrayByArraysClass(Integer[] array) {
//        Arrays.sort(array); // Ascending order sort
        Arrays.sort(array, Collections.reverseOrder()); // Descending order sort
    }
}
