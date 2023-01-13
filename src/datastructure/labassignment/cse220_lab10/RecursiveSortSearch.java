/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_lab10;

/**
 *
 * @author SDIPTO7
 */
import java.util.*;

public class RecursiveSortSearch {

    static int[] memoArr = new int[20];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = {10, 20, 0, 99, -3, -22};
        int[] b = {99, -9, -99, 1, -1, 20, 19};
        int[] c = {1, 5, 7, 77, -7, -1, 0, 11};
        int[] d = {8, -8, 5, 10, -2, 0, 2};
        int[] e = {4, 7, -6, 2, 9, 1, -7};
        System.out.println(findMax(a, a.length - 1));
        System.out.println(findMin(a, a.length - 1));
        System.out.println("Checking of Array SelectionSort(Recursive) with 4th array(d)");
        System.out.print("Initial Array: ");
        print(d);
        recursiveSelectionSort(d, 0);
        System.out.print("Sorted Array: ");
        print(d);
        System.out.println("Checking of Array InsertionSort(Recursive) with 1st array(a)");
        System.out.print("Initial Array: ");
        print(a);
        recursiveInsertionSort(a, 0, a.length - 1);
        System.out.print("Sorted Array: ");
        print(a);
        System.out.println("Checking of BinarySearch(Recursive) with 1st array(a)");
        System.out.println(binarySearch(a, 0, a.length - 1, -22));
        System.out.println(binarySearch(a, 0, a.length - 1, 99));
        System.out.println(binarySearch(a, 0, a.length - 1, 0));
        System.out.println("Checking of Non-dummy headed linear SinglyList SelectionSort(Recursive) with 2nd array(b)");
        Node x = toSinglyList(b);
        System.out.print("Initial Array: ");
        print(x);
        recursiveSelectionSort(x);
        System.out.print("Sorted Array: ");
        print(x);
        System.out.println("Checking of dummy headed linear doublyList BubbleSort(Recursive) with 3rd array(c)");
        Node y = toDoublyList(c);
        Node z;
        for (z = y; z.next != null; z = z.next) {
        }
        System.out.print("Initial Array: ");
        printDoublyList(y);
        recursiveBubbleSort(y, z);
        System.out.print("Sorted Array: ");
        printDoublyList(y);
        System.out.println("Checking of dummy headed linear doublyList InsertionSort(Recursive) with 5th array(e)");
        Node u = toDoublyList(e);
        Node v;
        for (v = u; v.next != null; v = v.next) {
        }
        System.out.print("Initial Array: ");
        printDoublyList(u);
        recursiveInsertionSort(u, v);
        System.out.print("Sorted Array: ");
        printDoublyList(u);
        System.out.println("Checking of nth Fibonacci number with Memoization");
        for (int i = 0; i < memoArr.length; i++) {
            memoArr[i] = -1;
        }
        System.out.println("Enter a number");
        int m = input.nextInt();
        int n = mFib(m);
        System.out.println("The " + m + "th fibonacci number is " + n);
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void print(Node head) {
        for (Node n = head; n != null; n = n.next) {
            System.out.print(n.data + " ");
        }
        System.out.println();
    }

    static void printDoublyList(Node head) {
        for (Node n = head.next; n != null; n = n.next) {
            System.out.print(n.data + " ");
        }
        System.out.println();
    }

    static Node toSinglyList(int[] a) {
        Node first = new Node(a[0], null, null);
        Node head = first;
        Node tail = first;
        for (int i = 1; i < a.length; i++) {
            Node next = new Node(a[i], null, null);
            tail.next = next;
            tail = next;
        }
        return head;
    }

    //Dummy headed non-circular doublyList
    static Node toDoublyList(int[] a) {
        Node head = new Node(0, null, null);
        Node tail = head;

        for (int i = 0; i < a.length; i++) {
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev = tail;
            tail = tail.next;
        }
//        tail.next = head; // Making it circular
//        head.prev = tail;
        return head;
    }

    static int findMax(int[] arr, int n) {
        if (n == 0) {
            return arr[n];
        }
        return Math.max(arr[n], findMax(arr, n - 1));
    }

    static int findMin(int[] arr, int n) {
        if (n == 0) {
            return arr[n];
        }
        return Math.min(arr[n], findMin(arr, n - 1));
    }

    static Node findMin(Node n) {
        if (n.next == null) {
            return n;
        }
        Node minNode = n;
        Node p = findMin(n.next);
        if (p.data < minNode.data) {
            minNode = p;
        }
        return minNode;
    }

    static int minLoc(int[] arr, int i) {
        if (i == arr.length - 1) {
            return i;
        }
        int j = minLoc(arr, i + 1);
        int index = (arr[i] < arr[j]) ? i : j;
        return index;
    }

    static void recursiveBubbleSort(Node y, Node z) {
        if (z.prev == y) {
            return;
        }
        for (Node p = y.next; p.next != null; p = p.next) {
            if (p.data > p.next.data) {
                int icu = p.data;
                p.data = p.next.data;
                p.next.data = icu;
            }
        }
        recursiveBubbleSort(y, z.prev);
    }

    static void recursiveSelectionSort(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        int minIndex = minLoc(arr, i);
        if (minIndex != i) {
            int icu = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = icu;
        }
        recursiveSelectionSort(arr, i + 1);
    }

    static void recursiveSelectionSort(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node minNode = findMin(head);
        int icu = head.data;
        head.data = minNode.data;
        minNode.data = icu;
        recursiveSelectionSort(head.next);
    }

    static void recursiveInsertionSort(int[] arr, int lower, int upper) {
        if (lower >= upper) {
            return;
        }
        recursiveInsertionSort(arr, lower, upper - 1);
        int key = arr[upper];
        int j = upper - 1;
        while (j >= 0 && key < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;//j becomes -1 at the end of the while loop.so, a[j+1] is a[0], the first position.
    }

    static void recursiveInsertionSort(Node y, Node z) {
        if (z.prev == y) {
            return;
        }
        recursiveInsertionSort(y, z.prev);
        int key = z.data;
        Node j = z.prev;
        while (j != y && key < j.data) {
            j.next.data = j.data;
            j = j.prev;
        }
        j.next.data = key;
    }

    static boolean binarySearch(int[] arr, int lower, int upper, int key) {
        if (lower > upper) {
            return false;
        } else {
            int mid = (lower + upper) / 2;
            if (key == arr[mid]) {
                return true;
            } else if (key > arr[mid]) {
                return binarySearch(arr, mid + 1, upper, key);
            } else {
                return binarySearch(arr, lower, mid - 1, key);
            }
        }
    }

    static int mFib(int n) {
        if (n <= 1) {
            return n;
        } else if (memoArr[n] != -1) {
            return memoArr[n];
        } else {
            memoArr[n] = mFib(n - 1) + mFib(n - 2);
            return memoArr[n];
        }
    }
}
