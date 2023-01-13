package datastructure.stream.conversion;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetConversion {

    public static void main(String[] args) {
        Set<Integer> set = IntStream.range(1, 8).boxed().collect(Collectors.toCollection(HashSet::new));
        set.add(null);
        set.add(7);

        Set<String> stringSet = getStringSet();

        Set<Employee> employeeSet = getEmployeeSet();

        System.out.println(Arrays.toString(convertSetToIntArray(set)));

        System.out.println(Arrays.toString(convertSetToIntegerArray(set)));

        System.out.println(convertSetToList(set));

        System.out.println(convertStringSetToIntegerSet(stringSet));

        System.out.println(convertEmployeeSetToMap(employeeSet));
    }

    private static int[] convertSetToIntArray(Set<Integer> set) {
        return set.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
    }

    private static Integer[] convertSetToIntegerArray(Set<Integer> set) {
        return set.stream().filter(Objects::nonNull).toArray(Integer[]::new);
    }

    private static List<Integer> convertSetToList(Set<Integer> set) {
        return set.stream().filter(Objects::nonNull).collect(Collectors.toCollection(LinkedList::new));
    }

    private static Set<Integer> convertStringSetToIntegerSet(Set<String> list) {
//        return list.stream().filter(Objects::nonNull).map(Integer::valueOf).collect(Collectors.toCollection(HashSet::new));
        return list.stream().filter(Objects::nonNull).map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));
    }

    private static Map<Integer, String> convertEmployeeSetToMap(Set<Employee> set) {
        return set.stream().filter(Objects::nonNull).collect(Collectors.toMap(Employee::getId, Employee::getName));
    }

    private static Set<Employee> getEmployeeSet() {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee(1, "Dipto"));
        employeeSet.add(new Employee(2, "Shahriar"));
        employeeSet.add(new Employee(3, "Rumi"));

        return employeeSet;
    }

    private static Set<String> getStringSet() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("1");
        stringSet.add("7");
        stringSet.add(null);
        stringSet.add("3");
        stringSet.add("5");

        return stringSet;
    }
}

class Employee {

    private int id;

    private String name;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
