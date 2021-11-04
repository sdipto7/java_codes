/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.cse221_lab07;

import java.util.*;
import java.io.*;

/**
 *
 * @author DIPTO
 */
public class DijkstraAlgo {

    static int[][] graph;
    static int[] parent;
    static int[] distance;
    static int size;
    static boolean[] visited;
    static String[] name;

    DijkstraAlgo() {
        graph = new int[size][size];
        parent = new int[size];
        distance = new int[size];
        visited = new boolean[size];
        name = new String[size];
        for (int i = 0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parent[i] = -1;
        }
    }

    static void dijkstra(int[][] graph, int source, int destination) {
        distance[source] = 0;
        for (int c = 0; c < size - 1; c++) {
            int u = min();
            visited[u] = true;
            for (int v = 0; v < size; v++) {
                if (distance[v] > distance[u] + graph[u][v] && graph[u][v] != 0 && !visited[v] && distance[u] != Integer.MAX_VALUE) {
                    parent[v] = u;
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        print(destination);
    }

    static int min() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < size; i++) {
            if (visited[i] == false && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void print(int destination) {
        System.out.println("Total Cost: " + distance[destination]);
        System.out.print("Path: " + destination);
        while (parent[destination] != -1) {
            System.out.print("<--" + parent[destination]);
            destination = parent[destination];
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src/algorithm/cse221_lab07/input.txt");
        Scanner input = new Scanner(file);
        Scanner sc = new Scanner(System.in);
        size = input.nextInt();
        new DijkstraAlgo();
        while (input.hasNextInt()) {
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();
            graph[x][y] = z;
        }
        System.out.println("Enter source and destination");
        dijkstra(graph, sc.nextInt(), sc.nextInt());
    }
}
