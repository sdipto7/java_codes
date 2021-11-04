/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_lab09;

/**
 *
 * @author SDIPTO7
 */
public class Recursion {

    static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return (num * (factorial(num - 1)));
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static void printArray(int[] a, int i) {
        if (i < a.length) {
            System.out.print(a[i] + " ");
            printArray(a, i + 1);
        } else {
            System.out.println();
        }
    }

    static String decimalToBinary(int num) {
        if (num > 0) {
            return (decimalToBinary(num / 2) + (num % 2));
        } else {
            return "";
        }
    }

    static int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        return x * pow(x, --y);
    }

    static Node list(Node n) {
        if (index == b.length) {
            return null;
        }
        Node m = new Node(b[index++], null);
        list(m);
        n.next = m;
        return n;
    }

    static void reverseListPrint(Node n) {
        if (n == null) {
            return;
        }
        reverseListPrint(n.next);
        System.out.print(n.data+" ");
    }

    static void listPrint(Node n) {
        if (n == null) {
           return;
        }
        System.out.print(n.data + " ");
        listPrint(n.next);
    }
    static int[] b = {0, 1, 2, 3, 4};
    static int index = 0;

    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(fibonacci(7));
        int[] a = {10, 20, 30, 40, 55, 50};
        printArray(a, 0);
        System.out.println(decimalToBinary(10));
        System.out.println(pow(3, 5));
        Node head = new Node(b[index++], null);
        head = list(head);
        listPrint(head);
        reverseListPrint(head);
    }
}
