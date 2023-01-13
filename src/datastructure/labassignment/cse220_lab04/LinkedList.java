/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.labassignment.cse220_lab04;

/**
 *
 * @author 18101324
 */
public class LinkedList {

    public Node head;

    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public LinkedList(Object[] a) {
        Node first = new Node(a[0], null);
        head = first;
        Node tail = first;
        for (int i = 1; i < a.length; i++) {
            Node next = new Node(a[i], null);
            tail.next = next;
            tail = next;
        }

    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(Node h) {
        head = h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode() {
        int count = 0;
        for (Node h = head; h != null; h = h.next) {
            count++;
        }
        return count; // please remove this line!
    }

    /* prints the elements in the list */
    public void printList() {
        for (Node h = head; h != null; h = h.next) {
            System.out.print(h.element + " ");
        }
        System.out.println();
    }

    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx) {
        if (idx >= 0 && idx < countNode()) {
            int count = 0;
            for (Node h = head; h != null; h = h.next) {
                if (count == idx) {
                    return h;
                }
                count++;
            }
        }
        return null; // please remove this line!
    }

// returns the element of the Node at the given index. For invalid idx return null.
    public Object get(int idx) {
        if (idx >= 0 && idx < countNode()) {
            Node n = nodeAt(idx);
            return n.element;
        }
        return null; // please remove this line!
    }

    /* updates the element of the Node at the given index. 
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, Object elem) {
        if (idx >= 0 && idx < countNode()) {
            Node h = nodeAt(idx);
            Object removed = h.element;
            h.element = elem;
            return removed;
        }
        return null; // please remove this line!
    }

    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem) {
        int index = 0;
        for (Node h = head; h != null; h = h.next, index++) {
            if (h.element == elem) {
                return index;
            }
        }
        return -1; // please remove this line!
    }

    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(Object elem) {
        for (Node h = head; h != null; h = h.next) {
            if (h.element == elem) {
                return true;
            }
        }
        return false; // please remove this line!
    }

    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList() {
        Node n = new Node(head.element, null);
        Node newHead = n;
        Node newTail = n;
        for (Node h = head.next; h != null; h = h.next) {
            Node next = new Node(h.element, null);
            newTail.next = next;
            newTail = next;
        }
        return newHead; // please remove this line!
    }

    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
    public Node reverseList() {
        Node newHead = new Node(head.element, null);
        for (Node h = head.next; h != null; h = h.next) {
            Node n = new Node(h.element, null);
            n.next = newHead;
            newHead = n;
        }
        return newHead; // please remove this line!
    }

    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx) {
        if (idx >= 0 && idx <= countNode()) {
            Node newNode = new Node(elem, null);
            if (idx == 0) {
                newNode.next = head;
                head = newNode;
            } else if (idx > 0 && idx < countNode()) {
                Node before = nodeAt(idx - 1);
                newNode.next = before.next;
                before.next = newNode;

            } else {
                Node before = nodeAt(idx - 1);
                before.next = newNode;
                newNode.next = null;
            }
        }
    }

    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index) {
        if (index >= 0 && index < countNode()) {
            Object removed;
            if (index == 0) {
                removed = head.element;
                head = head.next;
            } else if (index > 0 && index < countNode()) {
                Node before = nodeAt(index - 1);
                Node removedNode = before.next;
                before.next = before.next.next;
                removed = removedNode.element;
                removedNode.next = null;

            } else {
                Node before = nodeAt(index - 1);
                removed = before.next.element;
                before.next = null;
            }
            return removed;
        }
        return null; // please remove this line!
    }

    // Rotates the list to the left by 1 position.
    public void rotateLeft() {
        Node oldHead = head;
        head = head.next;
        oldHead.next = null;
        Node h = head;
        while (h.next != null) {
            h = h.next;
        }
        h.next = oldHead;
    }

    // Rotates the list to the right by 1 position.
    public void rotateRight() {
        Node h = head;
        while (h.next.next != null) {
            h = h.next;
        }
        Node newHead = h.next;
        h.next = null;
        newHead.next = head;
        head = newHead;
    }
}
