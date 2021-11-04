/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_lab07;

/**
 *
 * @author SDIPTO7
 */
public class ListStack implements Stack {

    int size;
    Node top;

    public ListStack() {
        size = 0;
        top = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Object e) throws StackOverflowException {
        Node n = new Node(e, null);
        n.next = top;
        top = n;
        size++;
    }

    public Object pop() throws StackUnderflowException {
        if (top != null) {
            Node n = top.next;
            Object popped = top.val;
            top.next = null;
            top.val = null;
            top = n;
            size--;
            return popped;
        } else {
            throw new StackUnderflowException();
        }
    }

    public Object peek() throws StackUnderflowException {
        if (top != null) {
            return top.val;
        } else {
            throw new StackUnderflowException();
        }
    }

    public String toString() {
        if (top != null) {
            String r = "";
            for (Node n = top; n != null; n = n.next) {
                r = r + n.val + " ";
            }
            return r;
        } else {
            return "Empty Stack";
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node n = top;
        for (int i = 0; i < size; i++, n = n.next) {
            arr[i] = n.val;
        }
        return arr;
    }

    public int search(Object e) {
        int count = 0;
        for (Node n = top; n != null; n = n.next) {
            if (n.val == e) {
                return count;
            } else {
                count++;
            }
        }
        return -1;
    }

}
