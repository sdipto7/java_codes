/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_extraLab;

import java.util.Scanner;

/**
 *
 * @author SDIPTO7
 */
//For ALL numbers
public class KeyIndexedSearchSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = {-5, 7, -3, 2, 4, -7, -7, 7, 4, -5, 4, -7};
//        int[] a = {6, 5, 7, 3, 2, 1, 4};
        int[] b;
        int increment = 0;
        int min = findMin(a);
        int max = findMax(a);
        if (min < 0) {
            int length = Math.abs(min) + max + 1;
            b = new int[length];
            increment = Math.abs(min);
        } else {
            b = new int[max + 1];
        }
        setArray(a, b, increment);
        System.out.println("Enter a number you want to search");
        int search = input.nextInt();
        contains(b, increment, search);
        print(a);
        sort(a, b, increment);
        print(a);
        print(b);
    }

    static void print(int[] x) {
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int findMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    static void setArray(int[] a, int[] b, int increment) {
        for (int i = 0; i < a.length; i++) {
            b[a[i] + increment] = b[a[i] + increment] + 1;
        }
    }

    static void contains(int[] b, int increment, int key) {
        if (key >= 0 - increment && key < b.length - increment) {
            if (b[key + increment] != 0) {
                System.out.println(key + " exists in the array");
            } else {
                System.out.println(key + " is not in the array");
            }
        } else {
            System.out.println("Wrong number range");
        }
    }

    static int[] copyArray(int[] x) {
        int[] y = new int[x.length];
        System.arraycopy(x, 0, y, 0, x.length);
        return y;
    }

    static void sort(int[] a, int[] b, int increment) {
        int[] c = copyArray(b);
        int i = 0;
        for (int key = 0; key < c.length; key++) {
            while (c[key] > 0) {
                a[i++] = key - increment;
                c[key]--;
            }
        }

    }
}
