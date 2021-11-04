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
public class Palindrome {

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 20, 10};
        int[] b = {30, 45, 60, 65, 65, 30, 45};
        int[] c = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
//        boolean check=palindromeCheck(a);
//        boolean check=palindromeCheck(b);
        boolean check=palindromeCheck(c);
        if (check == true) {
            System.out.println("This is a palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

    }

    static boolean palindromeCheck(int[] x) {
        int first = 0;
        int last = x.length - 1;
        boolean check = false;
        for (int i = 0; i < x.length / 2; i++) {
            if (x[first++] == x[last--]) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }
}
