package datastructure.stream.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListSort {

    public static void main(String[] args) {
        List<Integer> list = getIntegerList();

        System.out.println(sortList(list));

        sortListByCollections(list);

        System.out.println(list);
    }

    private static List<Integer> sortList(List<Integer> list) {
        return list.stream()
//                .sorted() // Ascending order sort
//                .sorted(Integer::compareTo) // Ascending order sort
                .sorted(Comparator.comparing(Integer::intValue, Collections.reverseOrder())) // Descending order sort
                .collect(Collectors.toList());
    }

    public static void sortListByCollections(List<Integer> list) {
//        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());
    }

    private static List<Integer> getIntegerList() {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(9);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(4);

        return list;
    }
}
