package random;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfListOfNumbers {
    public static void main(String[] args) {
        //Sum a list of numbers using IntStream
        int a = IntStream.range(1,15).sum(); //sum of first 15 numbers
        System.out.println(a);

        int[] array = IntStream.range(0,15).toArray(); //an array with each index values 0 - 15
        for (int i: array) {
            System.out.print(i +" ");
        }
        System.out.println();
        System.out.println(Arrays.stream(array).sum()); //sum of the array elements
    }
}
