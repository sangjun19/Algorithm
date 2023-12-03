
import java.sql.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int N = 10;
        List<Integer>[] adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        adjList[0].add(3);
        adjList[3].add(2);
        adjList[2].add(1);
        adjList[1].add(0);
        adjList[2].add(0);
        adjList[3].add(5);
        adjList[5].add(4);
        adjList[4].add(6);
        adjList[6].add(5);

        TopologicalSort topologicalSort = new TopologicalSort(adjList);
        System.out.println(topologicalSort.tsort());

    }
}
