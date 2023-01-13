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
//For Non-negative numbers;
public class KeyIndexedSearchSortNonNegative {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = {7, 5, 3, 4, 2, 1, 5, 7, 7, 2, 1, 0, 5};
        int max = findMax(a);
        int[] b = new int[max + 1];
        setArray(a, b);
        System.out.println("Enter a number you want search");
        int search = input.nextInt();
        contains(b, search);
        sort(a, b);
        print(a);
        print(b);

    }

    static void print(int[] x) {
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println();
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

    static void setArray(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[a[i]] = b[a[i]] + 1;
        }
    }

    static void contains(int[] b, int key) {
        if (key >= 0 && key < b.length) {
            if (b[key] != 0) {
                System.out.println(key + " exists in the array");
            } else {
                System.out.println("This number is not in the array");
            }
        } else {
            System.out.println("Wrong number range");
        }
    }

    static void sort(int[] a, int[] b) {
        int i = 0;
        int[] c = copyArray(b);
        for (int key = 0; key < c.length; key++) {
            while (c[key] > 0) {
                a[i++] = key;
                c[key]--;
            }
        }
    }

    static int[] copyArray(int[] x) {
        int[] c = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            c[i] = x[i];
        }
        return c;
    }
}
