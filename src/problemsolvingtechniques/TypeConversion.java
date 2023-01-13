package problemsolvingtechniques;

public class TypeConversion {

    public static void main(String[] args) {
        System.out.println(convertIntToInteger(7));
        System.out.println(convertIntegerToInt(Integer.valueOf(5)));
        System.out.println(convertIntToString(10));
        System.out.println(convertStringToInt("10"));
        System.out.println(convertCharToInt('a'));
        System.out.println(convertIntToChar(97));
        System.out.println(convertCharToString('D'));
    }

    private static int convertIntToInteger(int num) {
//        return new Integer(num);
        return Integer.valueOf(num);
    }

    private static int convertIntegerToInt(Integer num) {
        return num.intValue();
    }

    private static String convertIntToString(int num) {
        return String.valueOf(num);
    }

    private static int convertStringToInt(String num) {
//        return Integer.valueOf(num);
//        return Integer.valueOf(num).intValue();
        return Integer.parseInt(num);
    }

    private static int convertCharToInt(char ch) {
        return (int) ch; //explicit type casting not required as java implicitly converts char to it's ascii value
    }

    private static char convertIntToChar(int ascii) {
        return (char) ascii; //explicit type casting required here for converting ascii value to char
    }

    private static String convertCharToString(char ch) {
//        return Character.toString(ch);
        return String.valueOf(ch);
    }
}
