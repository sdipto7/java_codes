package algorithm.cse221_lab03;

/**
 *
 * @author DIPTO
 */
import java.util.*;

//Task-3(SHORTEST PATH)
public class Task03 {

    static LinkedList[] graph;
    static int n; //n is the size

    /*For this code I am not taking 0 index of array, 
    n-1 is actually the total number of nodes.
    I used n so I can use the array from 1 to n.*/
    Task03(int size) {
        graph = new LinkedList[size];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new LinkedList();
        }
    }

    static void addEdge(int x, int y) {
        graph[x].add(y);
//        graph[y].add(x);
    }

    static void BFS(int v) {
        boolean[] visit = new boolean[n];
        int[] level = new int[n];
        int[] parent = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        visit[v] = true;
        level[v] = 0;
        parent[v] = 0;
        q.add(v);
        while (!q.isEmpty()) {
            v = q.poll();
//            System.out.print(v + " -> ");
            Iterator<Integer> i = graph[v].iterator();
            while (i.hasNext()) {
                int p = i.next();
                if (visit[p] == false) {
                    level[p] = level[v] + 1;
                    visit[p] = true;
                    parent[p] = v;
                    q.add(p);
                }
            }
            if (q.contains(n - 1)) {
                int x = n - 1;
                while (parent[x] != 0) {
                    System.out.print(x + " <-- ");
                    x = parent[x];
                }
                System.out.println(x);
                break;
            }
        }
        System.out.println("Total Bridges: " + level[n - 1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int c = 1;
        while (c <= t) {
            System.out.println("Test Case " + c);
            n = input.nextInt() + 1;
            new Task03(n);
            int m = input.nextInt();
            int d = 1;
            while (d <= m) {
                int x = input.nextInt();
                int y = input.nextInt();
                addEdge(x, y);
                d++;
            }
            System.out.print("Path: ");
            BFS(1);
            c++;
        }
    }
}
