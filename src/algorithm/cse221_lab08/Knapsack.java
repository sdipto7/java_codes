/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.cse221_lab08;

import java.util.*;

/**
 *
 * @author DIPTO
 */
public class Knapsack {

    static int findMax(int a, int b) {
        return (a > b) ? a : b;
    }

    static int sack(int[] profit, int[] weight, int obj, int knapsack) {
        int[][] table = new int[obj + 1][knapsack + 1];
        for (int i = 0; i <= obj; i++) {
            for (int j = 0; j <= knapsack; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    table[i][j] = findMax(table[i - 1][j], table[i - 1][j - weight[i - 1]] + profit[i - 1]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        return table[obj][knapsack];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of objects- ");
        int obj = input.nextInt();
        System.out.println("Enter the weight of the Knapsack- ");
        int knapsack = input.nextInt();
        int[] p = new int[obj];
        int[] w = new int[obj];
        System.out.println("Enter profits");
        for (int i = 0; i < p.length; i++) {
            p[i] = input.nextInt();
        }
        System.out.println("Enter weights");
        for (int i = 0; i < w.length; i++) {
            w[i] = input.nextInt();
        }
        int sack = sack(p, w, obj, knapsack);
        System.out.println(sack);
    }
}
