package random;

import java.util.Scanner;

public class Sort {

    static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = {2, 4, 7, -4, -22, -5, 1, 3, 6};
//        int[] a = new int[10];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = input.nextInt();
//        }
//        print(a);
//        selectionSort(a);
//        print(a);
//        bubbleSort(a);
//        print(a);
        insertionSort(a);
        print(a);
    }

    static void print(Node head) {
        for (Node n = head; n != null; n = n.next) {
            System.out.print(n.data + " ");
        }
        System.out.println();
    }

    static Node toDoublyList(int[] a) {
        Node head = new Node(a[0], null, null);
        Node tail = head;

        for (int i = 1; i < a.length; i++) {
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev = tail;
            tail = tail.next;
        }
        return head;
    }

    static void insertionSort(int[] a) {
        int i, j, key, icu;
        for (i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;
            while (j >= 0 && key < a[j]) {
                icu = a[j];
                a[j] = a[j + 1];
                a[j + 1] = icu;
                j--;
            }
        }
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int icu = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = icu;
                }
            }
        }
    }

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minLoc = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minLoc]) {
                    minLoc = j;
                }
            }
            int icu = a[minLoc];
            a[minLoc] = a[i];
            a[i] = icu;
        }
    }
}

class Node {
    int data;
    Node next;
    Node prev;
    Node(int data,Node prev,Node next){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
}
