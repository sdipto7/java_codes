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

public class Task02 {

    static ArrayList[] graph;
    static int size;
    static Scanner input;
    static Stack<Integer> stack;
    static Stack<Integer> timeStack;
    static int time = 0;
    static String[] color;
    static int[] dt;
    static int[] ft;

    Task02() {
        graph = new ArrayList[size];
        color = new String[size];
        stack = new Stack<>();
        timeStack = new Stack<>();
        ft = new int[size];
        dt = new int[size];
        for (int i = 1; i < size; i++) {
            graph[i] = new ArrayList();
            color[i] = "white";
        }
    }

    static void addEdge(int x, int y) {
        graph[x].add(y);
    }

    static void topoSort(int u) {
        visit(u);
        System.out.print("After topological sort --> ");
        while (stack.empty() == false) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        System.out.print("Finishing time --> ");
        while (timeStack.empty() == false) {
            System.out.print(timeStack.pop() + " ");
        }
        System.out.println();
    }

    static void visit(int u) {
        color[u] = "grey";
        time += 1;
        int v;
        dt[u] = time;
        Iterator<Integer> ir = graph[u].iterator();
        while (ir.hasNext()) {
            v = ir.next();
            if (color[v] == "white") {
                visit(v);
            }
        }
        color[u] = "black";
        stack.push(u);
        ft[u] = ++time;
        timeStack.push(ft[u]);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\algorithm\\cse221_lab04\\graph.txt");
        input = new Scanner(file);
        size = input.nextInt() + 1;
        new Task02();
        while (input.hasNextInt()) {
            int x = input.nextInt();
            int y = input.nextInt();
            addEdge(x, y);
        }
        topoSort(1);
    }
}
