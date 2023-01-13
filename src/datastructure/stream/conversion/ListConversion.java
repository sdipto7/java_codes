package datastructure.stream.conversion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListConversion {

    public static void main(String[] args) {
//        List<Integer> list = IntStream.range(1, 8).boxed().collect(Collectors.toList());
        List<Integer> list = IntStream.range(1, 8).boxed().collect(Collectors.toCollection(ArrayList::new));
        list.add(7);
        list.add(3, null);
        list.add(5, null);

        List<String> stringList = getStringList();

        System.out.println(Arrays.toString(convertListToIntArray(list)));

        System.out.println(Arrays.toString(convertListToIntegerArray(list)));

        System.out.println(convertListToSet(list));

        System.out.println(getSetOfOddNumbersFromList(list));

        System.out.println(convertListToMapWithLongFrequencyAsValues(list));

        System.out.println(convertListToMapWithIntegerFrequencyAsValues(list));

        System.out.println(convertStringListToIntegerList(stringList));
    }

    private static int[] convertListToIntArray(List<Integer> list) {
//        return list.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
        return list.stream().filter(i -> i != null).mapToInt(Integer::intValue).toArray();
    }

    private static Integer[] convertListToIntegerArray(List<Integer> list) {
//        return list.stream().filter(i -> i != null).toArray(Integer[]::new);
        return list.stream().filter(Objects::nonNull).toArray(Integer[]::new);
    }

    private static Set<Integer> convertListToSet(List<Integer> list) {
//        return new HashSet<>(list);
        return list.stream().filter(Objects::nonNull).collect(Collectors.toCollection(HashSet::new));
    }

    private static Set<Integer> getSetOfOddNumbersFromList(List<Integer> list) {
//        return list.stream().filter(i -> Optional.ofNullable(i).isPresent() && (i % 2 == 1)).collect(Collectors.toCollection(TreeSet::new));
        return list.stream().filter(i -> (i != null) && (i % 2 == 1)).collect(Collectors.toCollection(TreeSet::new));
    }

    private static Map<Integer, Long> convertListToMapWithLongFrequencyAsValues(List<Integer> list) {
        return list.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    private static Map<Integer, Integer> convertListToMapWithIntegerFrequencyAsValues(List<Integer> list) {
        return list.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(e -> e, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    private static List<Integer> convertStringListToIntegerList(List<String> list) {
//        return list.stream().filter(Objects::nonNull).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
        return list.stream().filter(Objects::nonNull).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<String> getStringList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("7");
        stringList.add(null);
        stringList.add("3");
        stringList.add("5");

        return stringList;
    }
}
