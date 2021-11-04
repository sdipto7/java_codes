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

public class Task03a {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("src\\algorithm\\cse221_lab01\\input.txt");
        Scanner input = new Scanner(file);
        int size = Integer.parseInt(input.nextLine()); 
        /*for the comment part after while loop we need to use */
//        int size = Integer.parseInt(input.next());
        int[][] a = new int[size][size];
        while (input.hasNextLine()) {
//            input.nextLine();
//            int i = input.nextInt();
//            int j = input.nextInt();
            String[] x=(input.nextLine()).split(" ");
            int i=Integer.parseInt(x[0]);
            int j=Integer.parseInt(x[1]);
            a[i][j]++;
            a[j][i]++;
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
