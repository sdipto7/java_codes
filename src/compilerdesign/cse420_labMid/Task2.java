package compilerdesign.cse420_labMid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src/compilerdesign/cse420_labMid/task2_input.txt");
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
