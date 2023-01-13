package datastructure.stream.iteration;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIPracticeWithIntegers {

    public static void main(String[] args) {

        //Stream is created using Stream.of() and sorted
        System.out.println("Stream Created using Stream.of() and sorted: ");
        Stream.of(66, 24, 12, 17, 26).sorted().forEach(System.out::println);

        //Converting a List into a Stream and printing the entire Stream using forEach() method
        List<Integer> numberList = Arrays.asList(1, 2, 2, 3, 4, 5, 6);
        System.out.println("The Stream: ");
        numberList.forEach(System.out::print);
        System.out.println();
        lineBreak();

        //Returns the first number from the stream
        System.out.println(String.format("First number from the Stream is: %1$d", numberList.stream().findFirst().get()));
        lineBreak();

        //Filtering the even numbers from the numberList and using .collect() method to store into another list)
        System.out.println("even number list:");
        List<Integer> evenNumbersList = numberList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        evenNumbersList.forEach(System.out::println);
        lineBreak();

        //Filtering the distinct even numbers from the numberList and using .collect() method to store into another list)
        System.out.println("distinct even number list:");
        List<Integer> distinctEvenNumbersList = numberList.stream().filter(x -> x % 2 == 0).distinct().collect(Collectors.toList());
        distinctEvenNumbersList.forEach(System.out::println);
        lineBreak();

        //Filtering the odd numbers from the numberList and directly printing using forEach())
        System.out.println("odd number list:");
        numberList.stream().filter(x -> x % 2 != 0).forEach(System.out::println);
        lineBreak();

        //Mapping/Converting the numberList into Squares of the numbers and storing into another list
        System.out.println("square of the number list:");
        List<Integer> squareList = numberList.stream().map(x -> x * x).collect(Collectors.toList());
        squareList.forEach(System.out::println);
        lineBreak();

        //Mapping/Converting the numberList into cubes of the numbers and directly printing
        System.out.println("cube of the number list:");
        numberList.stream().map(x -> x * x * x).forEach(System.out::println);
        lineBreak();

        //Mapping/Converting the numberList into cubes of the distinct numbers and directly printing
        System.out.println("cube of the distinct numbers:");
        numberList.stream().map(x -> x * x * x).distinct().forEach(System.out::println);
        lineBreak();

        //Max Number using reduce() function
        Optional<Integer> maxNumber = numberList.stream().reduce((num1, num2) -> num1 > num2 ? num1 : num2);
        System.out.println(String.format("Maximum number using reduce(): %1$d", maxNumber.get()));
        lineBreak();

        //Min Number using reduce() function
        Integer minNumber = numberList.stream().reduce((num1, num2) -> num1 < num2 ? num1 : num2).orElse(0);
        System.out.println(String.format("Minimum number using reduce(): %1$d", minNumber));
        lineBreak();

        //Max Number using reduce() function
        Integer maxSquareNumber = numberList.stream().map(x -> x * x).reduce(0, (num1, num2) -> num1 > num2 ? num1 : num2);
        System.out.println(String.format("Maximum squared number using reduce(): %1$d", maxSquareNumber));
        lineBreak();

        //Few calculations using summaryStatistics()
        System.out.println("Using IntSummaryStatistics to get max, min, sum, average from the stream: ");
        IntSummaryStatistics summaryStatistics = numberList.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(String.format("Maximum number in the stream: %1$d", summaryStatistics.getMax()));
        System.out.println(String.format("Minimum number in the stream: %1$d", summaryStatistics.getMin()));
        System.out.println(String.format("Sum number in the stream: %1$d", summaryStatistics.getSum()));
        System.out.println(String.format("Average number in the stream: %1$.2f", summaryStatistics.getAverage()));
    }

    public static void lineBreak() {
        System.out.println("=======================================");
    }
}