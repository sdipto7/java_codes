package random;

public class BinaryRepresentation {
    public static void main(String[] args) {
        //Binary representation of a number
        int n = 20;
        String bit = Integer.toBinaryString(n);
        String bit2 = Integer.toHexString(n);
        System.out.println(bit);
        System.out.println(bit2);
    }
}
