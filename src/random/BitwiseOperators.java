/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

/**
 *
 * @author DIPTO
 */
public class BitwiseOperators {
    public static void main(String[] args){
        int a = 15; // 15 = 0000 1111
        int b = 27; // 27 = 0001 1011
        
        //Binary AND operator(&)
        int and = a&b; // 0000 1111 & 0001 1011 = 0000 1011
        System.out.println("And operation: " + and);
        
        //Binary OR operator(|)
        int or = a|b; // 0000 1111 | 0001 1011 = 0001 1111
        System.out.println("OR operation: " + or);
        
        //Binary XOR operator(^)
        int xor = a^b; // 0000 1111 ^ 0001 1011 = 0001 0100
        System.out.println("XOR operation: " + xor);
        
        //Binary one complement operator(~)
        int complement = ~a;
        System.out.println("one complement operation: " + complement);
        
        //Binary left shift operator(<<)
        int leftshift = a << 2; //15 = 0000 1111,2 bits left shift = 0011 1100
        System.out.println("LeftShift operation: " + leftshift);
        
        //Binary right shift operator(>>)
        int rightshift = a >> 2; //15 = 0000 1111,2 bits right shift = 0000 0011
        System.out.println("RightShift operation: " + rightshift);
        
        //Binary right shift zero fill operator(>>>)
        int shiftRightZero = a >>> 2;
        System.out.println("RightShiftZeroFill operation: " + shiftRightZero);
    }
}
