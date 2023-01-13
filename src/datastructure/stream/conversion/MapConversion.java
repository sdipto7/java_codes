package datastructure.stream.conversion;

import java.util.*;
import java.util.stream.Collectors;

public class MapConversion {

    public static void main(String[] args) {
        Map<Integer, Integer> map = getMap();

        System.out.println(Arrays.toString(convertMapKeysToIntArray(map)));
        System.out.println(Arrays.toString(convertMapValuesToIntArray(map)));
        System.out.println(Arrays.toString(convertMapKeysToIntegerArray(map)));
        System.out.println(Arrays.toString(convertMapValuesToIntegerArray(map)));

        System.out.println(convertMapKeysToList(map));
        System.out.println(convertMapValuesToList(map));
        System.out.println(convertMapKeysSortedByValueToList(map));
        System.out.println(convertMapValuesSortedByKeyToList(map));

        System.out.println(convertMapKeysToSet(map));
        System.out.println(convertMapValuesToSet(map));
    }

    private static int[] convertMapKeysToIntArray(Map<Integer, Integer> map) {
        return map.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] convertMapValuesToIntArray(Map<Integer, Integer> map) {
        return map.values().stream().mapToInt(Integer::intValue).toArray();
    }

    private static Integer[] convertMapKeysToIntegerArray(Map<Integer, Integer> map) {
        return map.keySet().stream().toArray(Integer[]::new);
    }

    private static Integer[] convertMapValuesToIntegerArray(Map<Integer, Integer> map) {
        return map.values().stream().toArray(Integer[]::new);
    }

    private static List<Integer> convertMapKeysToList(Map<Integer, Integer> map) {
//        return new ArrayList<>(map.keySet());
//        return map.keySet().stream().collect(Collectors.toCollection(LinkedList::new));
        return map.keySet().stream().collect(Collectors.toList());
    }

    private static List<Integer> convertMapValuesToList(Map<Integer, Integer> map) {
//        return new LinkedList<>(map.values());
//        return map.values().stream().collect(Collectors.toCollection(LinkedList::new));
        return map.values().stream().collect(Collectors.toList());
    }

    private static List<Integer> convertMapKeysSortedByValueToList(Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Collections.reverseOrder())) //for ascending order remove Collections.reverseOrder()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<Integer> convertMapValuesSortedByKeyToList(Map<Integer, Integer> map) {
        return map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey, Collections.reverseOrder())) //for ascending order remove Collections.reverseOrder()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private static Set<Integer> convertMapKeysToSet(Map<Integer, Integer> map) {
//        return new HashSet<>(map.keySet());
//        return map.keySet().stream().collect(Collectors.toSet());
        return map.keySet().stream().collect(Collectors.toCollection(TreeSet::new));
    }

    private static Set<Integer> convertMapValuesToSet(Map<Integer, Integer> map) {
//        return new TreeSet<>(map.values());
//        return map.values().stream().collect(Collectors.toSet());
        return map.values().stream().collect(Collectors.toCollection(HashSet::new));
    }

    private static Map<Integer, Integer> getMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 101);
        map.put(2, 103);
        map.put(3, 102);
        map.put(4, 100);

        return map;
    }
}
