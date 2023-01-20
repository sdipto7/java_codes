package problemsolvingtechniques;

public class BitReverse {

    public static void main(String[] args) {
        int positiveNumber = 7, negativeNumber = -7;
        int positiveNumberWithReversedBits = reverseBits(positiveNumber), negativeNumberWithReversedBits = reverseBits(negativeNumber);

        System.out.println(String.format("The binary representation of %d is: %s",
                positiveNumber, convertDecimalToBinary(positiveNumber)));

        System.out.println(String.format("The binary representation of %d is: %s",
                positiveNumberWithReversedBits, convertDecimalToBinary(positiveNumberWithReversedBits)));

        System.out.println();

        System.out.println(String.format("The binary representation of %d is: %s",
                negativeNumber, convertDecimalToBinary(negativeNumber)));

        System.out.println(String.format("The binary representation of %d is: %s",
                negativeNumberWithReversedBits, convertDecimalToBinary(negativeNumberWithReversedBits)));
    }

    private static int reverseBits(int num) {
        int numberWithReversedBits = 0;
        for (int i = 0; i < 31; i++) {
            numberWithReversedBits = (numberWithReversedBits << 1) | (num & 1);
            num = num >> 1;
        }

        return numberWithReversedBits;
    }

    private static String convertDecimalToBinary(int num) {
        StringBuilder binaryNumber = new StringBuilder(); // We can also use array with length 32 to store each bit value of 32-bit integer
        for (int bit = 31; bit >= 0; --bit) {
            int bitValue = ((num >> bit) & 1) == 1 ? 1 : 0;
            binaryNumber.append(bitValue);
        }

        return binaryNumber.toString();
    }
}
