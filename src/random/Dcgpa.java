/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Dcgpa {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("C:\\Users\\DIPTO\\IdeaProjects\\java_codes\\src\\Random\\DCGPA.txt");
        Scanner input = new Scanner(file);
        double sum = 0.0;
        int numberOfCourses = 0;
        while (input.hasNextDouble()) {
            double gpa = input.nextDouble();
            sum += gpa;
            numberOfCourses++;
        }
        double cgpa = (sum / numberOfCourses);
        System.out.printf("Your CGPA after taking %d courses is: %.2f\n"
                + "And you earned %d credits\n", numberOfCourses, cgpa, (numberOfCourses * 3));
    }
}
