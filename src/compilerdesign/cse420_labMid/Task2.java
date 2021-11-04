package compilerdesign.cse420_labMid;

import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\DIPTO\\Documents\\NetBeansProjects\\java_codes\\src\\compilerdesign.cse420_labMid\\task2_input.txt");
        Scanner input = new Scanner(file);
        int count = 0;

        Pattern pattern = Pattern.compile("[A-Za-z]*The[A-Za-z]*|[A-Za-z]*the[A-Za-z]*");
        String line = input.nextLine();
        String[] word = line.split(" ");
        for (int i = 0; i < word.length; i++) {
            Matcher matcher = pattern.matcher(word[i]);
            if (matcher.find()) {
                count++;
                i++;
            }
        }

        System.out.println(count);
    }
}
