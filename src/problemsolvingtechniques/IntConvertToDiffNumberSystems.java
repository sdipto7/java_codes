package problemsolvingtechniques;

public class IntConvertToDiffNumberSystems {

    public static void main(String[] args) {
        int num = 16;

        System.out.println(String.format("Binary Representation of Integer %d is: %s", num, getBinaryRepresentation(num)));
        System.out.println(String.format("Octal Representation of Integer %d is: %s", num, getOctalRepresentation(num)));
        System.out.println(String.format("Hexadecimal Representation of Integer %d is: %s", num, getHexadecimalRepresentation(num)));
    }

    private static String getBinaryRepresentation(int num) {
        return Integer.toBinaryString(num);
    }

    private static String getOctalRepresentation(int num) {
        return Integer.toOctalString(num);
    }

    private static String getHexadecimalRepresentation(int num) {
        return Integer.toHexString(num);
    }
}
