package problemsolvingtechniques;

public class IntReverse {

    public static void main(String[] args) {
        System.out.println(String.format("Reversed Number of %d is: %d", 6125, getReversedNumber(6125)));
        System.out.println(String.format("Reversed Number of %d is: %d", -6125, getReversedNumber(-6125)));
        System.out.println(String.format("Reversed Number of %d is: %d", 1234, getReversedNumber(1234)));
        System.out.println(String.format("Reversed Number of %d is: %d", -1234, getReversedNumber(-1234)));
        System.out.println(String.format("Reversed Number of %d is: %d", 1221, getReversedNumber(1221)));
        System.out.println(String.format("Reversed Number of %d is: %d", -1221, getReversedNumber(-1221)));
        System.out.println(String.format("Reversed Number of %d is: %d", -1, getReversedNumber(-1)));
        System.out.println(String.format("Reversed Number of %d is: %d", -10, getReversedNumber(-10)));
    }

    private static int getReversedNumber(int number) {
        boolean isNegativeNumber = number < 0;
        //making the number positive before reversing, will make the number negative again while returning
        if (isNegativeNumber) {
            number *= (-1);
        }

        int reversedNumber = 0;
        while (number > 0) {
            reversedNumber = (reversedNumber * 10) + (number % 10);
            number /= 10;
        }

        return isNegativeNumber ? (-1) * reversedNumber : reversedNumber;
    }
}
