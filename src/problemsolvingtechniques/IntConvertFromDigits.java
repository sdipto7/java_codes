package problemsolvingtechniques;

import java.util.Arrays;

public class IntConvertFromDigits {

    public static void main(String[] args) {
        int[] digitArray1 = new int[]{1, 2, 3, 4};
        int[] digitArray2 = new int[]{5, 2, 7, 9};
        System.out.println(String.format("The number generated from the array %s is: %d", Arrays.toString(digitArray1), getIntFromDigitsByArray(digitArray1)));
        System.out.println(String.format("The number generated from the array %s is: %d", Arrays.toString(digitArray2), getIntFromDigitsByArray(digitArray2)));

        /*
        This below conversion from StringBuilder or String can be very easily done by the
        Integer.parseInt(stringBuilder.toString()) method. But using the getIntFromDigitsByStringBuilder method,
        the performance of the code gets better.
        */
        StringBuilder stringBuilder = new StringBuilder("5279");
        System.out.println(String.format("The number generated from the StringBuilder %s is: %d", stringBuilder, getIntFromDigitsByStringBuilder(stringBuilder)));
    }

    public static int getIntFromDigitsByArray(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value = (value * 10) + num;
        }

        return value;
    }

    public static int getIntFromDigitsByStringBuilder(StringBuilder stringBuilder) {
        int value = 0;
        for (int i = 0; i < stringBuilder.length(); ++i) {
            value = (value * 10) + ((int) stringBuilder.charAt(i) - 48);
        }

        return value;
    }
}
