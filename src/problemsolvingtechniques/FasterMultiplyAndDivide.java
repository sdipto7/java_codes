package problemsolvingtechniques;

public class FasterMultiplyAndDivide {

    public static void main(String[] args) {
        int num = 24;

        //Multiplication by binary bit left shifting
        System.out.println(String.format("%d multiplied by 2 is: %d", num, multiplyByTwo(num))); //multiply with 2 or 1-bit left shift
        System.out.println(String.format("%d multiplied by 4 is: %d", num, multiplyByFour(num))); //multiply with 4 or 2-bit left shift
        System.out.println(String.format("%d multiplied by 8 is: %d", num, multiplyByEight(num))); //multiply with 8 or 3-bit left shift

        //Division by binary bit right shifting
        System.out.println(String.format("%d divided by 2 is: %d", num, divideByTwo(num))); //divide by 2 or 1-bit right shift
        System.out.println(String.format("%d divided by 4 is: %d", num, divideByFour(num))); //divide by 4 or 2-bit right shift
        System.out.println(String.format("%d divided by 8 is: %d", num, divideByEight(num))); //divide by 8 or 3-bit right shift
    }

    private static int multiplyByTwo(int num) {
        return num << 1;  //multiply num with 2 or 1-bit left shift
    }

    private static int multiplyByFour(int num) {
        return num << 2;  //multiply num with 4 or 2-bit left shift
    }

    private static int multiplyByEight(int num) {
        return num << 3;  //multiply num with 8 or 3-bit left shift
    }

    private static int divideByTwo(int num) {
        return num >> 1; //divide num by 2 or 1-bit right shift
    }

    private static int divideByFour(int num) {
        return num >> 2; //divide num by 4 or 2-bit right shift
    }

    private static int divideByEight(int num) {
        return num >> 3; //divide num by 8 or 3-bit right shift
    }
}
