package problemsolvingtechniques.dt_conversion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* We can use both Arrays.stream() method or Stream.of()/IntStream.of()/LongStream.of()/DoubleStream.of() for converting using
 * stream api as both produces same result. Arrays.stream() works for int,long,double primitive type array and any object T type array.
 * Stream.of() for T[] array, IntStream.of() for int[] array, LongStream.of() for long[] array, DoubleStream.of() for double[] array.
 * Again, we can use Collectors.toList()/Collectors.toSet() to get a list/set, or we can get implementations
 * like ArrayList/HashSet by using Collectors.toCollection(ArrayList::new)/Collectors.toCollection(HashSet::new).
 * boxed() method wraps up each int value to an Integer object,
 * and it is needed because Collections can only be used with object and wrapper classes.
 */
public class ArrayConversion {

    public static void main(String[] args) {
        int[] intArray = new int[]{7, 8, 9, 7, 5, 1};
        Integer[] integerArray = new Integer[]{7, 8, 9, 7, 5, 1};
        String[] stringArray = new String[]{"7", null, "8", "5", "7", "1", "3"};
        Character[] characterArray = new Character[]{'d', 'i', 'p', 't', 'o'};

        System.out.println(convertArrayToList(intArray));

        System.out.println(convertArrayToSet(intArray));

        System.out.println(convertArrayToMapWithLongFrequencyAsValues(intArray));

        System.out.println(convertArrayToMapWithIntegerFrequencyAsValues(intArray));

        System.out.println(convertArrayToMapWithIndexAsKeys(intArray));

        System.out.println(Arrays.toString(convertIntArrayToIntegerArray(intArray)));

        System.out.println(Arrays.toString(convertIntegerArrayToIntArray(integerArray)));

        System.out.println(Arrays.toString(convertStringArrayToIntArray(stringArray)));

        System.out.println(Arrays.toString(convertStringArrayToIntegerArray(stringArray)));

        System.out.println(Arrays.toString(convertCharacterArrayToIntArrayWithAsciiValue(characterArray)));
    }

    private static List<Integer> convertArrayToList(int[] array) {
//        return Arrays.stream(array).boxed().collect(Collectors.toList());
//        return Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
//        return IntStream.of(array).boxed().collect(Collectors.toList());
        return IntStream.of(array).boxed().collect(Collectors.toCollection(LinkedList::new));
    }

    private static Set<Integer> convertArrayToSet(int[] array) {
//        return Arrays.stream(array).boxed().collect(Collectors.toSet());
//        return Arrays.stream(array).boxed().collect(Collectors.toCollection(HashSet::new));
//        return IntStream.of(array).boxed().collect(Collectors.toSet());
        return IntStream.of(array).boxed().collect(Collectors.toCollection(TreeSet::new));
    }

    /* Collectors.counting() returns a long value as frequency count */
    private static Map<Integer, Long> convertArrayToMapWithLongFrequencyAsValues(int[] array) {
//        return Arrays.stream(array).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return IntStream.of(array).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    /* By using Collectors.reducing() we can get integer value as frequency count */
    private static Map<Integer, Integer> convertArrayToMapWithIntegerFrequencyAsValues(int[] array) {
//        return Arrays.stream(array).boxed().collect(Collectors.groupingBy(e -> e, Collectors.reducing(0, e -> 1, Integer::sum)));
        return IntStream.of(array).boxed().collect(Collectors.groupingBy(e -> e, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    private static Map<Integer, Integer> convertArrayToMapWithIndexAsKeys(int[] array) {
        return IntStream.range(0, array.length).boxed().collect(Collectors.toMap(i -> i, i -> array[i]));
    }

    private static Integer[] convertIntArrayToIntegerArray(int[] array) {
//        return Arrays.stream(array).boxed().toArray(Integer[]::new);
        return IntStream.of(array).boxed().toArray(Integer[]::new);
    }

    private static int[] convertIntegerArrayToIntArray(Integer[] array) {
//        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        return Stream.of(array).mapToInt(Integer::intValue).toArray();
    }

    private static int[] convertStringArrayToIntArray(String[] array) {
//        return Stream.of(array).filter(i -> i != null).mapToInt(Integer::valueOf).toArray();
//        return Arrays.stream(array).filter(i -> i != null).mapToInt(Integer::valueOf).toArray();
//        return Stream.of(array).filter(i -> i != null).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(array).filter(i -> i != null).mapToInt(Integer::parseInt).toArray();
    }

    private static Integer[] convertStringArrayToIntegerArray(String[] array) {
//        return Stream.of(array).filter(i -> i != null).map(Integer::new).toArray(Integer[]::new);
        return Arrays.stream(array).filter(i -> i != null).map(Integer::new).toArray(Integer[]::new);
    }

    private static int[] convertCharacterArrayToIntArrayWithAsciiValue(Character[] array) {
//        return Stream.of(array).mapToInt(Character::charValue).toArray();
//        return Arrays.stream(array).mapToInt(Character::charValue).toArray();
//        return Stream.of(array).mapToInt(c -> (int) c).toArray();
        return Arrays.stream(array).mapToInt(c -> (int) c).toArray();
    }
}
