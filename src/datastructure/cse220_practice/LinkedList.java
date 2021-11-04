/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_practice;

/**
 *
 * @author SDIPTO7
 */
public class LinkedList {

    public Node head;

    LinkedList(Student[] array) {
        head = new Node(array[0], null);
        Node tail = head;
        for (int i = 1; i < array.length; i++) {
            Node newNode = new Node(array[i], null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    LinkedList(Student[] array1, Student[] array2) {
        Node first = new Node(array1[0], null);
        Node second = new Node(array2[0], null);
        head = first;
        Node tail = second;
        head.next = tail;
        if (array2.length < array1.length) {
            for (int i = 1; i < array1.length; i++) {
                if (i >= array2.length) {
                    Node r = new Node(array1[i], null);
                    tail.next = r;
                    tail = r;
                } else {
                    Node p = new Node(array1[i], null);
                    Node q = new Node(array2[i], null);
                    tail.next = p;
                    p.next = q;
                    tail = q;
                }
            }
        } else {
            for (int i = 1; i < array2.length; i++) {
                if (i >= array1.length) {
                    Node r = new Node(array2[i], null);
                    tail.next = r;
                    tail = r;
                } else {
                    Node p = new Node(array1[i], null);
                    Node q = new Node(array2[i], null);
                    tail.next = p;
                    p.next = q;
                    tail = q;
                }
            }

        }
    }

    void print() {
        for (Node n = head; n != null; n = n.next) {
            System.out.println("Name: " + n.student.name + " ID: " + n.student.id + " CGPA: " + n.student.cgpa);
        }
        System.out.println();
    }

    void sort() {
        for (Node n = head; n.next != null; n = n.next) {
            for (Node m = n.next; m != null; m = m.next) {
                if (m.student.cgpa > n.student.cgpa) {
                    Student spiderMan = n.student;
                    n.student = m.student;
                    m.student = spiderMan;
                } else if (m.student.cgpa == n.student.cgpa) {
                    if (m.student.name.compareToIgnoreCase(n.student.name) < 0) {
                        Student spiderMan = n.student;
                        n.student = m.student;
                        m.student = spiderMan;
                    }
                }
            }
        }
    }
}
