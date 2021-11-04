package algorithm.cse221_lab02;

public class SortTest {

    public static void main(String[] args) {
        int array[] = {3, 5, 10, 23, 25, 8, 7, 9, 50, 47};
        MyArray ma = new MyArray(array);
        System.out.println("Initial Array: " + ma);
        ma.insertionSort();
        System.out.println("After Insertion Sort: " + ma); //This should print the sorted array
        MyArray ma1 = new MyArray(array);
        ma1.mergeSort(ma1.a);
        System.out.println("After Merge Sort: " + ma1); //This should print the sorted array
        MyArray ma2 = new MyArray(array);
        ma2.quickSort(0, ma2.a.length-1);
        System.out.println("After Quick Sort: " + ma2); //This should print the sorted array
    }
}
