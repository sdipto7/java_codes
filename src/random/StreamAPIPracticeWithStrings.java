package random;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIPracticeWithStrings {
    public static void main(String[] args) {
        List<String> nameList = getNameList();

        //Printing all strings
        System.out.println("All Names: ");
        nameList.forEach(System.out::println);
        lineBreak();

        //Printing strings in all upper case
        System.out.println("Upper cases of names: ");
        nameList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        lineBreak();

        //Printing strings in all lower case
        System.out.println("Lower cases of names: ");
        List<String> lowerCaseNameList = nameList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        lowerCaseNameList.forEach(System.out::println);
        lineBreak();

        //Printing strings which starts with S
        System.out.println("Names that start with 'S': ");
        nameList.stream()
                .filter(string -> string.startsWith("S"))
                .forEach(System.out::println);
        lineBreak();

        //Printing strings in all upper case which starts with S
        System.out.println("Upper cases of names that start with 'S': ");
        nameList.stream()
                .filter(string -> string.startsWith("S"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        lineBreak();

        //Printing strings in all lower case which starts with P
        System.out.println("Lower cases of names that start with 'P': ");
        Stream<Object> lowerCaseNameStream = nameList.stream()
                .filter(string -> string.startsWith("P"))
                .map(String::toLowerCase);
        lowerCaseNameStream.forEach(System.out::println);
        lineBreak();

        //Printing numebr of characters in each string
        System.out.println("Number of characters in each name: ");
        nameList.stream()
                .map(string -> String.format("Name: %1$s -> Number of characters: %2$s", string, string.length()))
                .forEach(System.out::println);
        lineBreak();

        //Printing names in upper cases which has less than 15 characters
        System.out.println("Names having less than 15 characters: ");
        nameList.stream()
                .filter(string -> string.length() < 15)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        lineBreak();

        //Printing names in upper cases which has greater than or equal to 15 characters
        System.out.println("Names having more or equal to 15 characters: ");
        nameList.stream()
                .filter(string -> string.length() >= 15)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        lineBreak();

        //Printing the name which has most character
        System.out.println("The name with most number characters: ");
        Optional<String> nameWithMostCharacter = nameList.stream()
                .reduce((string1, string2) -> string1.length() > string2.length() ? string1 : string2);
        nameWithMostCharacter.ifPresent(System.out::println);
        lineBreak();

        //Printing the name which has least character
        System.out.println("The name with least number characters: ");
        Optional<String> nameWithLeastCharacter = nameList.stream()
                .reduce((string1, string2) -> string1.length() < string2.length() ? string1 : string2);
        nameWithLeastCharacter.ifPresent(System.out::println);
        lineBreak();
    }

    public static List<String> getNameList() {
        return Arrays.asList(
                "Shahriar Rumi Dipto",
                "Sheikh Fahim",
                "Priata Nowshin",
                "Priata Nowshin Oshru"
        );
    }

    public static void lineBreak() {
        System.out.println("=======================================");
    }
}
