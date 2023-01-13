package datastructure.stream.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class SetSorting {

    public static void main(String[] args) {
        Set<Integer> set = getIntegerSet();
        Set<Student> studentSet = getStudentSet();

        System.out.println(sortSet(set));

        System.out.println(sortStudentSetById(studentSet));
        System.out.println(sortStudentSetByName(studentSet));
    }

    /* Collecting to HashSet after sorting does not guarantee the sorting order.
     * LinkedHashSet preserves the insertion order after sorting.
     */
    private static Set<Integer> sortSet(Set<Integer> set) {
//        return new TreeSet<>(set);
        return set.stream()
//                .sorted() // Ascending order sort
//                .sorted(Integer::compareTo) // Ascending order sort
                .sorted(Comparator.comparing(Integer::intValue, Collections.reverseOrder())) // Descending order sort
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /* Collecting to HashSet after sorting does not guarantee the sorting order.
     * LinkedHashSet preserves the insertion order after sorting.
     */
    private static Set<Student> sortStudentSetById(Set<Student> set) {
        return set.stream()
                .sorted(Comparator.comparing(Student::getId, Collections.reverseOrder()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /* Collecting to HashSet after sorting does not guarantee the sorting order.
     * LinkedHashSet preserves the insertion order after sorting.
     */
    private static Set<Student> sortStudentSetByName(Set<Student> set) {
        return set.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static Set<Integer> getIntegerSet() {
        Set<Integer> set = new HashSet<>();
        set.add(7);
        set.add(9);
        set.add(3);
        set.add(2);
        set.add(6);
        set.add(4);

        return set;
    }

    private static Set<Student> getStudentSet() {
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1, "Dipto"));
        studentSet.add(new Student(2, "Shahriar"));
        studentSet.add(new Student(3, "Rumi"));

        return studentSet;
    }
}

class Student {

    private int id;

    private String name;

    public Student() {
    }

    public Student(int id, String name) {
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

