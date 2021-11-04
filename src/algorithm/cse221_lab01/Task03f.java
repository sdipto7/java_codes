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

public class Task03f {

    public static void main(String[] args) throws IOException, FileNotFoundException {
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
        }
        int[] oD=new int[size];
        int[] iD=new int[size];
        for(int a=0;a<arr.length;a++){
            oD[a]=arr[a].size();
            for(int b=0;b<arr[a].size();b++){
                iD[(int)arr[a].get(b)]++;
            }
        }
        System.out.println("OUT/IN Degree: ");
        for(int x=0;x<size;x++){
            System.out.println(x+" --> "+oD[x]+"/"+iD[x]);
        }
    }
}
