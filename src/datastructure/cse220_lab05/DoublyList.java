/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_lab05;

/**
 *
 * @author SDIPTO7
 */
public class DoublyList {

    public Node head;

    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public DoublyList(Object[] a) {
        head = new Node(null, null, null);
        Node tail = head;

        for (int i = 0; i < a.length; i++) {
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev = tail;
            tail = tail.next;
        }
        tail.next = head; // Making it circular
        head.prev = tail;
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h) {
        head = h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode() {
        int count = 0;
        for (Node n = head.next; n != head; n = n.next) {
            count++;
        }

        return count; // please remove this line!
    }

    /* prints the elements in the list */
    public void forwardprint() {
        for (Node n = head.next; n != head; n = n.next) {
            System.out.print(n.element + " ");
        }
        System.out.println();
    }

    public void backwardprint() {
        for (Node n = head.prev; n != head; n = n.prev) {
            System.out.print(n.element + " ");
        }
        System.out.println();
    }

    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx) {
        if (idx >= 0 && idx < countNode()) {
            int count = 0;
            for (Node n = head.next; n != head; n = n.next, count++) {
                if (count == idx) {
                    return n;
                }
            }
        }

        return null; // please remove this line!
    }

    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem) {
        int index = 0;
        for (Node n = head.next; n != head; n = n.next, index++) {
            if (n.element == elem) {
                return index;
            }
        }

        return -1; // please remove this line!
    }

    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx) {
        if (idx >= 0 && idx <= countNode()) {
            Node alien = new Node(elem, null, null);
            Node icu;
            if (idx == countNode()) {
                icu = head;
            } else {
                icu = nodeAt(idx);
            }
            alien.next = icu;
            alien.prev = icu.prev;
            icu.prev.next = alien;
            icu.prev = alien;

        }

    }

    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index) {
        if (index >= 0 && index < countNode()) {
            Node rip = nodeAt(index);
            rip.prev.next = rip.next;
            rip.next.prev = rip.prev;
            Object icu = rip.element;
            rip.next = rip.prev = null;
            rip.element = null;
            return icu;
        }

        return null; // please remove this line!
    }

}
