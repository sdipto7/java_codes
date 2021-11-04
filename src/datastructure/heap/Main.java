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
public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(2);
        heap.insert(5);
        heap.insert(3);
        heap.insert(4);
        heap.insert(15);
        heap.print();
//        System.out.println(heap.h[heap.size-1]);
//        System.out.println(heap.h.length);
//        System.out.println(heap.size);
        for(int i=1;i<heap.h.length;i++){
            heap.delete();
        }
        heap.print();
    }
}
