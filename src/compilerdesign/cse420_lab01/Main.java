package compilerdesign.cse420_lab01;

import java.util.*;
import java.io.*;

public class Main {

    static String[] keyword = {"if", "while", "for", "do", "else", "try", "catch", "import", "else if", "final", "int", "double", "float", 
        "String", "char", "static", "switch", "case", "return", "continue", "goto", "break"};
    static String[] mathOperator = {"+", "-", "*", "/", "%"};
    static String[] logicalOperator = {"<", ">", "=", ">=", "<=", "&&", "||"};
    static String[] other = {",", ";", "(", ")", "{", "}", "[", "]"};

    static Set<String> output_Keyword = new HashSet<String>();
    static Set<String> output_mathOperator = new HashSet<String>();
    static Set<String> output_logicalOperator = new HashSet<String>();
    static Set<String> output_other = new HashSet<String>();
    static Set<String> output_numericalValue = new HashSet<String>();
    static Set<String> output_identifier = new HashSet<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\DIPTO\\Documents\\NetBeansProjects\\java_codes\\src\\compilerdesign.cse420_lab01\\input.txt");
        Scanner sc = new Scanner(file);

        List<String> keywordList = Arrays.asList(keyword);
        List<String> mathOperatorList = Arrays.asList(mathOperator);
        List<String> logicalOperatorList = Arrays.asList(logicalOperator);
        List<String> otherList = Arrays.asList(other);

        while (sc.hasNext()) {
            String string = sc.next();

            if (keywordList.contains(string)) {
                output_Keyword.add(string);
            } else if (mathOperatorList.contains(string)) {
                output_mathOperator.add(string);
            } else if (logicalOperatorList.contains(string)) {
                output_logicalOperator.add(string);
            } else if (otherList.contains(string)) {
                output_other.add(string);
            } else if (isNumber(string)) {
                output_numericalValue.add(string);
            } else {
                output_identifier.add(string);
            }
        }

        System.out.println("Keywords:" + output_Keyword);
        System.out.println("Identifiers:" + output_identifier);
        System.out.println("Math Operator:" + output_mathOperator);
        System.out.println("Logical Operator:" + output_logicalOperator);
        System.out.println("Numerical Values:" + output_numericalValue);
        System.out.println("Others:" + output_other);

    }

    static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
