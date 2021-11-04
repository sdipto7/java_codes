package compilerdesign.cse420_labMid;

import java.util.Scanner;
import java.io.*;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
         File file = new File("C:\\Users\\DIPTO\\Documents\\NetBeansProjects\\java_codes\\src\\compilerdesign.cse420_labMid\\task1_input.txt");
         Scanner input = new Scanner(file);
         while(input.hasNext()){
             String line = input.next();
             if(line.contains("@")){
                 String[] email = line.split("@");
                 if(email[1].contains("com")){
                     String[] domain = email[1].split("\\.");
                     System.out.println(domain[0]);
                 }else{
                     System.out.println(email[1]);
                 }
             }else{
                 System.out.println("Not an email");
             }
         }
    }
}
