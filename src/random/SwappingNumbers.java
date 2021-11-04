package random;

public class SwappingNumbers {
    public static void main(String[] args) {
        //swapping numbers without using a 3rd variable
        int x = 5, y = 15;
        x -= y;
        y += x;
        x = y-x;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
