package problemsolvingtechniques;

import java.util.Arrays;

public class IntConvertFromDigits {

    public static void main(String[] args) {
        int[] digitArray1 = new int[]{1, 2, 3, 4};
        int[] digitArray2 = new int[]{5, 2, 7, 9};
        System.out.println(String.format("The number generated from the array %s is: %d", Arrays.toString(digitArray1), getIntFromDigits(digitArray1)));
        System.out.println(String.format("The number generated from the array %s is: %d", Arrays.toString(digitArray2), getIntFromDigits(digitArray2)));
    }

    public static int getIntFromDigits(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value = (value * 10) + num;
        }

        return value;
    }
}
