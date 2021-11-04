/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign.cse420_lab04;

/**
 * @author DIPTO
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src/compilerdesign/cse420_lab04/input.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.startsWith("public") || line.startsWith("private") || line.startsWith("protected")) {
                int i = 0;
                while (i < line.length()) {
                    if (line.charAt(i) == '(') {
                        String[] methods = line.split("\\(");
//                        System.out.println(methods[0]+"         "+methods[1]);
                        String[] words = methods[0].split(" ");
//                        System.out.println(words[0]+"         "+words[1]);
                        int len = words.length;
                        System.out.println("Method: " + words[len - 1] + "(" + methods[1] + " \nReturn Type: " + words[len - 2] + " \n");
                    }
                    ++i;
                }
            }
        }
    }
}
