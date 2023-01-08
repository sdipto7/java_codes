package problemsolvingtechniques;

public class PowerOfTwo {

    public static void main(String[] args) {
        for (int num = 1; num < 17; ++num) {
            print(num, isPowerOfTwo(num));
        }
    }

    private static boolean isPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }

    private static void print(int num, boolean isPowerOfTwo) {
        System.out.println(String.format("Is 2 power some number is %d ? : %s", num, isPowerOfTwo ? "Yes" : "No"));
    }
}
