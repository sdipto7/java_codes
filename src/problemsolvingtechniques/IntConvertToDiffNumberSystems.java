package problemsolvingtechniques;

public class IntConvertToDiffNumberSystems {

    public static void main(String[] args) {
        int positiveNum = 16;
        int negativeNum = -16;

        System.out.println(String.format("Octal Representation of Positive Integer %d using builtin method is: %s",
                positiveNum, getOctalRepresentationByIntegerClass(positiveNum)));

        System.out.println(String.format("Hexadecimal Representation of Positive Integer %d using builtin method is: %s",
                positiveNum, getHexadecimalRepresentationByIntegerClass(positiveNum)));

        System.out.println(String.format("Binary Representation of Positive Integer %d using builtin method is: %s",
                positiveNum, getBinaryRepresentationByIntegerClass(positiveNum)));

        System.out.println(String.format("Binary Representation of Positive Integer %d is: %s",
                positiveNum, convertDecimalToBinary(positiveNum)));

        System.out.println(String.format("Binary Representation of Positive Integer using bit shifting technique %d is: %s",
                positiveNum, convertDecimalToBinaryUsingBitShiftingOperators(positiveNum)));

        System.out.println();

        System.out.println(String.format("Octal Representation of Negative Integer %d using builtin method is: %s",
                positiveNum, getOctalRepresentationByIntegerClass(negativeNum)));

        System.out.println(String.format("Hexadecimal Representation of Negative Integer %d using builtin method is: %s",
                positiveNum, getHexadecimalRepresentationByIntegerClass(negativeNum)));

        System.out.println(String.format("Binary Representation of Negative Integer %d using builtin method is: %s",
                positiveNum, getBinaryRepresentationByIntegerClass(negativeNum)));

        System.out.println(String.format("Binary Representation of Negative Integer %d is: %s",
                positiveNum, convertDecimalToBinary(negativeNum)));

        System.out.println(String.format("Binary Representation of Negative Integer using bit shifting technique %d is: %s",
                positiveNum, convertDecimalToBinaryUsingBitShiftingOperators(negativeNum)));
    }

    private static String getBinaryRepresentationByIntegerClass(int num) {
        return Integer.toBinaryString(num);
    }

    /* This technique will work only for positive decimal number*/
    private static String convertDecimalToBinary(int num) {
        StringBuilder binaryNumber = new StringBuilder(); // We can also use array with length 32 to store each bit value of 32-bit integer
        while (num > 0) {
            binaryNumber.append(num % 2);
            num = num / 2;
        }

        return binaryNumber.reverse().toString();
    }

    /* This bit shifting technique will work for both positive and negative decimal number*/
    private static String convertDecimalToBinaryUsingBitShiftingOperators(int num) {
        StringBuilder binaryNumber = new StringBuilder(); // We can also use array with length 32 to store each bit value of 32-bit integer
        for (int bit = 31; bit >= 0; --bit) {
            int bitValue = ((num >> bit) & 1) == 1 ? 1 : 0;
            binaryNumber.append(bitValue);
        }

        return binaryNumber.toString();
    }

    private static String getOctalRepresentationByIntegerClass(int num) {
        return Integer.toOctalString(num);
    }

    private static String getHexadecimalRepresentationByIntegerClass(int num) {
        return Integer.toHexString(num);
    }
}
