package datastructure.stream.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class MapSorting {

    public static void main(String[] args) {
        Map<Integer, Integer> map = getMap();

        System.out.println(sortMapByKeys(map));
        System.out.println(sortMapByValues(map));
    }

    /* Collecting to HashMap after sorting does not guarantee the sorting order.
     * LinkedHashMap preserves the insertion order after sorting.
     */
    private static Map<Integer, Integer> sortMapByKeys(Map<Integer, Integer> map) {
        return map.entrySet()
                .stream()
//                .sorted(Map.Entry.comparingByKey())
                .sorted(Comparator.comparing(Map.Entry::getKey)) // Sorted by default ascending order
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    /* Collecting to HashMap after sorting does not guarantee the sorting order.
     * LinkedHashMap preserves the insertion order after sorting.
     */
    private static Map<Integer, Integer> sortMapByValues(Map<Integer, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder())) // Sorted by descending order
//                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
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
