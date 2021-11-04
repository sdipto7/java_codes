/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package datastructure.cse220_lab02;

/**
 *
 * @author SDIPTO7
 */
public class LinearArray {

    public static void printArray(int[] source) {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

    public static void printReverse(int[] source) {
        for (int i = source.length - 1; i >= 0; i--) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

    public static int[] copyArray(int[] source, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = source[i];
        }
        return arr;
    }

    public static void reverseArray(int[] source) {
        for (int i = 0, j = source.length - 1; i < j; i++, j--) {
            int icu = source[i];
            source[i] = source[j];
            source[j] = icu;
        }
    }

    public static int[] shiftLeft(int[] source, int k) {
//        int[] arr = new int[source.length];
        for (int i = 0; i < source.length - k; i++) {
            source[i] = source[i + k];
        }
        for (int i = source.length - k; i < source.length; i++) {
            source[i] = 0;
        }
        return source;
    }

    public static int[] rotateLeft(int[] source, int k) {
        int[] arr = new int[source.length];
        for (int i = 0; i < arr.length; i++) {
            int icu = ((i - k) + arr.length) % arr.length;
            arr[icu] = source[i];
        }
        return arr;
    }

    public static int[] shiftRight(int[] source, int k) {
//        int[] arr = new int[source.length];
        for (int i = source.length - 1; i >= 0 + k; i--) {
            source[i] = source[i - k];
        }
        for (int i = 0; i < 0 + k; i++) {
            source[i] = 0;
        }
        return source;
    }

    public static int[] rotateRight(int[] source, int k) {
        int[] arr = new int[source.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int icu = (i + k) % arr.length;
            arr[icu] = source[i];
        }
        return arr;
    }

    public static boolean insert(int[] arr, int size, int elem, int index) {
        if (size == arr.length) {
            System.out.println("No space left");
            return false;
        } else {
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = elem;
            System.out.println("Number of elements after insertion: " + (size + 1));
            return true;
        }
    }

    public static boolean removeAll(int[] arr, int size, int elem) {
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == elem) {
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = 0;
                size--;
                check = true;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};

        System.out.println("\n///// TEST 01: Copy Array example /////");
        int[] b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 

        System.out.println("\n///// TEST 02: Print Reverse example /////");
        printArray(a); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        printReverse(a); // This Should Print: { 60, 50, 40, 30, 20, 10 } 

        System.out.println("\n///// TEST 03: Reverse Array example /////");
        reverseArray(b);
        printArray(b); // This Should Print: { 60, 50, 40, 30, 20, 10 } 

        System.out.println("\n///// TEST 04: Shift Left k cell example /////");
        b = copyArray(a, a.length);
        b = shiftLeft(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 0, 0, 0 } 

        System.out.println("\n///// TEST 05: Rotate Left k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = rotateLeft(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 

        System.out.println("\n///// TEST 06: Shift Right k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = shiftRight(b, 3);
        printArray(b);  // This Should Print: { 0, 0, 0, 10, 20, 30 } 

        System.out.println("\n///// TEST 07: Rotate Right k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = rotateRight(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 

        System.out.println("\n///// TEST 08: Insert example 1 /////");

        b = copyArray(a, a.length);
        printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        boolean bol = insert(b, 6, 70, 2); // This Should Print: No space Left 
        System.out.println(bol); // This Should Print: false
        printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60} 

        System.out.println("\n///// TEST 09: Insert example 2 /////");
        int[] c = {10, 20, 30, 40, 50, 0, 0};
        printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 }
        bol = insert(c, 5, 70, 2);  // This Should Print: Number of elements after insertion: 6
        System.out.println(bol); // This Should Print: true
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 

        System.out.println("\n///// TEST 10: Insert example 3 /////");
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 
        bol = insert(c, 6, 70, 6); // This Should Print: Number of elements after insertion: 7 
        System.out.println(bol); // This Should Print: true
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 

        System.out.println("\n///// TEST 11: Remove example 1 /////");

        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
        bol = removeAll(c, 7, 90);
        System.out.println(bol); // This Should Print: false
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 

        System.out.println("\n///// TEST 12: Remove example 2 /////");
        printArray(c);  // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
        bol = removeAll(c, 7, 70);
        System.out.println(bol); // This Should Print: true
        printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 } 
    }
}
