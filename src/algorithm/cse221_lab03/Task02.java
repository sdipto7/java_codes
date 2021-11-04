package algorithm.cse221_lab03;

/**
 *
 * @author DIPTO
 */
import java.util.*;
import java.io.*;

//Task-2
public class Task02 {

    static LinkedList[] graph;
    static int size;
    static Scanner input;
    static Iterator<Integer> i; //Iterator is for traversing the list

    Task02(int size) {
        graph = new LinkedList[size];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList();
        }
    }

    static void edge(int x, int y) {
        /*if edge(0,1) is given and edge(1,0) not given 
        then this will be an directed graph and if graph[y].add(x)
        is not commented then it will be an undirected graph.
         */
        graph[x].add(y);
//        graph[y].add(x);
    }

    static void bfs(int v) {
        System.out.print("Breadth first search from vertex " + v + "--> ");
        int[] visit = new int[size];
        Queue<Integer> q = new ArrayDeque<>();
        visit[v] = 1;
        q.add(v);
        while (!q.isEmpty()) {
            v = q.remove();
            System.out.print(v + " ");
            i = graph[v].iterator();
            while (i.hasNext()) {
                int p = i.next();
                if (visit[p] != 1) {
                    visit[p] = 1;
                    q.add(p);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("src\\algorithm.cse221_lab03\\graph.txt");
        input = new Scanner(file);
        size = input.nextInt() + 1;
        Task02 g = new Task02(size);
        while (input.hasNextInt()) {
            int x = input.nextInt();
            int y = input.nextInt();
            edge(x, y);
        }
        bfs(1);
        bfs(4);
        bfs(2);
        bfs(5);
        bfs(6);
        bfs(3);
    }
}
