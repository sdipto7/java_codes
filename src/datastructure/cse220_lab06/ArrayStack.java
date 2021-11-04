/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.cse220_lab06;

/**
 *
 * @author SDIPTO7
 */
public class ArrayStack implements Stack {

    int size;
    Object[] data;

    public ArrayStack() {
        size = 0;
        data = new Object[5];
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
        if (size < data.length) {
            data[size] = e;
            size++;
        } else {
            throw new StackOverflowException();
        }
    }

    public Object pop() throws StackUnderflowException {
        if (size > 0) {
            Object popped = data[size - 1];
            data[size - 1] = null;
            size--;
            return popped;
        } else {
            throw new StackUnderflowException();
        }
    }

    public Object peek() throws StackUnderflowException {
        if (size > 0) {
            return data[size - 1];
        } else {
            throw new StackUnderflowException();
        }
    }

    public String toString() {
        if (size > 0) {
            String r = "";
            for (int i = size - 1; i >= 0; i--) {
                r = r + data[i] + " ";
            }
            return r;
        } else {
            return "Empty Stack";
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        int j = size - 1;
        for (int i = 0; i < size; i++, j--) {
            arr[i] = data[j];
        }
        return arr;
    }

    public int search(Object e) {
        int count = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == e) {
                return count;
            } else {
                count++;
            }
        }
        return -1;
    }

}
