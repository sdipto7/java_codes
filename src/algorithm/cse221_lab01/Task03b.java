/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.cse221_lab01;

/**
 *
 * @author DIPTO
 */
import java.util.*;
import java.io.*;

public class Task03b {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\algorithm\\cse221_lab01\\input.txt");
        Scanner input = new Scanner(file);
        int size = input.nextInt();
        int[][] a = new int[size][size];
        while (input.hasNextLine()) {
            input.nextLine();
            int i = input.nextInt();
            int j = input.nextInt();
            a[i][j]++;
        }
        for (int i = 0; i < 1; i++) {
            System.out.print(" ");
            for (int j = 0; j < a.length; j++) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
        for (int x = 0; x < a.length; x++) {
            System.out.print(x + " ");
            for (int y = 0; y < a[x].length; y++) {
                System.out.print(a[x][y] + " ");
            }
            System.out.println();
        }
    }
}
