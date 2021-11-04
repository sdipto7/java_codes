/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.cse221_lab04;

/**
 *
 * @author DIPTO
 */
import java.io.*;
import java.util.*;

public class Task03 {

    static ArrayList[] graph;
    static int size;
    static Scanner input;
    static int[] pi;
    static String[] color;
    static Stack<Integer> stack;

    Task03() {
        graph = new ArrayList[size];
        pi = new int[size];
        color = new String[size];
        stack = new Stack<>();
        for (int i = 1; i < size; i++) {
            graph[i] = new ArrayList();
            color[i] = "white";
            pi[i] = -1;
        }
    }

    static void addEdge(int x, int y) {
        graph[x].add(y);
    }

    static void DFS(int v) {
        DFS_visit(v);
        while (!stack.empty()) {
            if (stack.peek() == 9) {
                int s = stack.pop();
                System.out.print("Path: "+s);
                while (pi[s] != -1) {
                    System.out.print(" <-- " + pi[s]);
                    s = pi[s];
                }
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    static void DFS_visit(int u) {
        color[u] = "grey";
        Iterator<Integer> ir = graph[u].iterator();
        while (ir.hasNext()) {
            int v = ir.next();
            if (color[v] == "white") {
                pi[v] = u;
                DFS_visit(v);
            }
        }
        color[u] = "black";
        stack.push(u);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\algorithm\\cse221_lab04\\maze.txt");
        input = new Scanner(file);
        size = input.nextInt() + 1;
        new Task03();
        while (input.hasNextInt()) {
            int x = input.nextInt();
            int y = input.nextInt();
            addEdge(x, y);
        }
        DFS(1);
    }
}
