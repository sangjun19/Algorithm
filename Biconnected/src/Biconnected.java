import java.util.*;

public class Biconnected {
    int sequence;
    int dfsnum[];
    int lownum[];
    List<Integer>[] adjList;
    Stack<Integer> stack;
    Biconnected(List<Integer>[] graph) {
        adjList = graph;
        int n = adjList.length;
        sequence = 0;
        lownum = new int[n];
        dfsnum = new int[n];
        Arrays.fill(dfsnum, -1);
        Arrays.fill(lownum, -1);
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (dfsnum[i] == -1) {
                biconnected(i, -1);
            }
        }
    }

    void biconnected(int v, int u) {
        dfsnum[v] = sequence;
        lownum[v] = sequence++;
        for (int w : adjList[v]) {
            if (w != u && dfsnum[w] < dfsnum[v]) {
                stack.push(v);
                stack.push(w);
            }
            if (dfsnum[w] == -1) {
                biconnected(w, v);
                lownum[v] = Math.min(lownum[v], lownum[w]);
                if (lownum[w] >= dfsnum[v]) {
                    List<Integer> component = new ArrayList<>();
                    while (true) {
                        int numW = stack.pop();
                        int numV = stack.pop();
                        component.add(numV);
                        component.add(numW);
                        System.out.print("("+numW+","+numV +") ");
                        if (v == numV && w == numW) break;
                    }
                    System.out.println("\n---------------");
                }
            } else if (w != u) {
                lownum[v] = Math.min(lownum[v], dfsnum[w]);
            }
        }
    }
}
