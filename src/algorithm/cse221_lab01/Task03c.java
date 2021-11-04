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

public class Task03c {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\algorithm\\cse221_lab01\\input.txt");
        Scanner input = new Scanner(file);
        int size = input.nextInt();
        ArrayList[] arr = new ArrayList[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList();
        }
        while (input.hasNextLine()) {
            input.nextLine();
            int i = input.nextInt();
            int j = input.nextInt();
            arr[i].add(j);
            arr[j].add(i);
        }
        for (int a = 0; a < arr.length; a++) {
            System.out.print(a + " --> ");
            for (int b = 0; b < arr[a].size(); b++) {
                System.out.print(arr[a].get(b)+" ");
            }
            System.out.println();
        }
    }
}
