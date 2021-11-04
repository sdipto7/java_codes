package compilerdesign.cse420_lab03;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfRE = input.nextInt();
        String[] RE = new String[numberOfRE];
        for (int i = 0; i < RE.length; i++) {
            RE[i] = input.next();
        }
        int numberOfExp = input.nextInt();
        for (int j = 1; j <= numberOfExp; j++) {
            String line = input.next();
            boolean check = false;
            for (int i = 0; i < RE.length; i++) {
                Pattern pattern = Pattern.compile(RE[i]);
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    System.out.println("YES, " + (i+1));
                    check = true;
                    break;
                }else{
                    check = false;
                }
            }
            if(!check){
                System.out.println("NO, " + 0);
            }
        }
    }
}
