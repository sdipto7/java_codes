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

public class Task01 {

    static ArrayList[] graph;
    static int size;
    static Scanner input;
    static int time = 0;
    static int[] pi;
    static String[] color;
    static int[] dt;
    static int[] ft;
    static String pn = "Processed Nodes\n";
    static String dn = "Discovered Nodes\n";

    Task01() {
        graph = new ArrayList[size];
        pi = new int[size];
        color = new String[size];
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

    static void DFS(int v) {
        DFS_visit(v);
        System.out.println(dn);
        System.out.println(pn);
    }

    static void DFS_visit(int u) {
        dn += u + " ";
        color[u] = "grey";
        time += 1;
        dt[u] = time;
        Iterator<Integer> ir = graph[u].iterator();
        while (ir.hasNext()) {
            int v = ir.next();
            if (color[v] == "white") {
                pi[v] = u;
                DFS_visit(v);
            }
        }
        color[u] = "black";
        ft[u] = ++time;
        pn += u + " ";
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\algorithm\\cse221_lab04\\graph.txt");
        input = new Scanner(file);
        size = input.nextInt() + 1;
        new Task01();
        while (input.hasNextInt()) {
            int x = input.nextInt();
            int y = input.nextInt();
            addEdge(x, y);
        }
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the vertex for DFS: ");
//        int d = sc.nextInt();
//        DFS(d);
        DFS(1);
    }
}
