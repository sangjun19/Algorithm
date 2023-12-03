
import java.sql.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int N = 10;
        List<Integer>[] adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        adjList[0].add(1);
        adjList[1].add(0); adjList[1].add(2); adjList[1].add(3);
        adjList[2].add(1); adjList[2].add(3);
        adjList[3].add(1); adjList[3].add(2);

//        adjList[0].add(1);
//        adjList[1].add(2); adjList[1].add(0); adjList[1].add(3);
//        adjList[2].add(1); adjList[2].add(4);
//        adjList[3].add(4); adjList[3].add(1); adjList[3].add(5);
//        adjList[4].add(2); adjList[4].add(3);
//        adjList[5].add(3); adjList[5].add(6); adjList[5].add(7);
//        adjList[6].add(7); adjList[6].add(5);
//        adjList[7].add(5); adjList[7].add(6); adjList[7].add(9); adjList[7].add(8);
//        adjList[8].add(7);
//        adjList[9].add(7);

//        adjList[0].add(3);
//        adjList[3].add(2);
//        adjList[2].add(1);
//        adjList[1].add(0);
//        adjList[2].add(0);
//        adjList[3].add(5);
//        adjList[5].add(4);
//        adjList[4].add(6);
//        adjList[6].add(5);

        Biconnected biconnected = new Biconnected(adjList);
    }
}
