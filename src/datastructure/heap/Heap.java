/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.heap;

/**
 *
 * @author DIPTO
 */
public class Heap {

    int[] h;
    int size;

    Heap() {
        h = new int[1];
        size = 1;
    }

    void insert(int key) {
        resize(h);
        int index = h.length - 1;
        h[index] = key;
        size++;
        swim(index);
    }

    void swim(int index) {
        if (index == 1) {
            return;
        }
        int parent = index / 2;
        if (h[parent] >= h[index]) {
            return;
        } else {
            swap(parent, index);
            swim(parent);
        }
    }

    void swap(int x, int y) {
        int icu = h[x];
        h[x] = h[y];
        h[y] = icu;
    }

    void delete() {
        if (size == 0) {
            return;
        }
        swap(1, size-1);
        size--;
        maxHeapify(1);
    }

    void maxHeapify(int index) {
        if (size == 0) {
            return;
        }
        int left = 2 * index;
        int right = 2 * index + 1;
            if (left <= size && right <= size) {
                if (h[left] > h[right]) {
                    swap(index, left);
                    maxHeapify(left);
                } else {
                    swap(index, right);
                    maxHeapify(right);
                }
            } else if (left <= size && right > size) {
                swap(index, left);
            }
    }

    void resize(int[] a) {
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, a.length);
        h = b;
    }

    void print() {
        for (int i = 1; i < h.length; i++) {
            System.out.print(h[i] + " ");
        }
        System.out.println();
    }
}
