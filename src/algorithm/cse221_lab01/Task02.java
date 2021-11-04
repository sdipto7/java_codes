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

public class Task02 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\algorithm\\cse221_lab01\\input.txt");
        Scanner input = new Scanner(file);
        input.useDelimiter("\\Z");
//        System.out.print(input.next());
        while (input.hasNext()) {
            System.out.print(input.next());
        }
//////        Using BufferedReader;
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String st;
//        while ((st = br.readLine()) != null) {
//            System.out.println(st);
//        }
//////          Using FileReader;
//        FileReader fr = new FileReader(file);
//        int i;
//        while ((i = fr.read()) != -1) {
//            System.out.print((char) i);
//        }
    }
}
