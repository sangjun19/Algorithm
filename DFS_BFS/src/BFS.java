import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    int N;
    boolean [] visited;
    public BFS (List<Edge>[] adjList) {
        N = adjList.length;
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            visited[i] = false;
        }
        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                bfs(adjList, i);

            }
        }
    }

    void bfs(List<Edge>[] adjList, int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);
        while(!q.isEmpty()) {
            int j = q.remove();
            System.out.print(j + " ");
            for(Edge e: adjList[j]) {
                if(!visited[e.adjvertex]) {
                    visited[e.adjvertex] = true;
                    q.add(e.adjvertex);
                }
            }
        }
    }
}
