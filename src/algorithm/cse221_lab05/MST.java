/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.cse221_lab05;

import java.util.*;

/**
 *
 * @author DIPTO
 */
public class MST {
    
    static int[][] graph;
    static int size;
    static String[] city;
    static int[] parent;
    static int[] key;
    static boolean[] visited;
    
    MST() {
        graph = new int[size][size];
        city = new String[size];
        parent = new int[size];
        key = new int[size];
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
    }
    
    static void prim(int[][] graph) {
        key[0] = 0;
        for (int c = 0; c < size; c++) {
            int index = min();
            visited[index] = true;
            for (int d = 0; d < size; d++) {
                if (graph[index][d] != 0 && visited[d] == false && graph[index][d] < key[d]) {
                    parent[d] = index;
                    key[d] = graph[index][d];
                }
            }
        }
        print();
    }

    static void print() {
        for (int i = 1; i < size; i++) {
            System.out.print("(" + city[parent[i]] + " - " + city[i] + ") ");
        }
    }
    
    static int min() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < size; i++) {
            if (visited[i] == false && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        System.out.println("Enter number of cities");
        size = input.nextInt();
        new MST();
//        System.out.println("Enter name of cities");
        for (int i = 0; i < size; i++) {
            city[i] = input.next();
        }
//        System.out.println("Give distances");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
//                System.out.print("distance from " + city[i] + " to " + city[j]);
                graph[i][j] = input.nextInt();
            }
        }
        prim(graph);
    }
}
/*
inputs-
6
DHAKA
CHITTAGONG
BARISHAL
SYLHET
RAJSHAHI
KHULNA
0 264 277 346 270 335 264 0 541 425 534 599 277 541 0 623 401 322 346 425 623 0 616 694 270 534 401 616 0 295 335 599 322 694 295 0
*/