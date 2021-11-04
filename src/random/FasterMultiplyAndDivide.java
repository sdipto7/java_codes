package random;

public class FasterMultiplyAndDivide {
    public static void main(String[] args) {
        //Bit shifting
        int num1 = 4;
        int num2 = 16;

        //Multiplication by binary bit left shifting
        System.out.println(num1 << 1); //multiply num1 with 2 or 1-bit left shift
        System.out.println(num1 << 2); //multiply num1 with 4 or 2-bit left shift
        System.out.println(num1 << 3); //multiply num1 with 8 or 3-bit left shift
        System.out.println(num1 << 4); //multiply num1 with 16 or 4-bit left shift

        //Division by binary bit right shifting
        System.out.println(num2 >> 1); //divide num2 by 2 or 1-bit right shift
        System.out.println(num2 >> 2); //divide num2 by 4 or 2-bit right shift
        System.out.println(num2 >> 3); //divide num2 by 8 or 3-bit right shift
        System.out.println(num2 >> 4); //divide num2 by 16 or 4-bit right shift
    }
}
