package problemsolvingtechniques;

public class IntReverse {

    public static void main(String[] args) {
        printNumber(6125, getReversedNumber(6125));
        printNumber(-6125, getReversedNumber(-6125));
        printNumber(1234, getReversedNumber(1234));
        printNumber(-1234, getReversedNumber(-1234));
        printNumber(1221, getReversedNumber(1221));
        printNumber(-1221, getReversedNumber(-1221));
        printNumber(-1, getReversedNumber(-1));
        printNumber(-10, getReversedNumber(-10));
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

    private static void printNumber(int number, int reversedNumber) {
        System.out.println(String.format("Reversed Number of %d is: %d", number, reversedNumber));
    }
}
