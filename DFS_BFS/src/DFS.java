import java.util.ArrayList;
import java.util.List;

public class DFS {
    int N;
    boolean [] visited;
    public DFS(List<Edge>[] adjList) {
        N = adjList.length;
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            visited[i] = false;
        }
        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                dfs(adjList, i);
            }
        }
    }

    void dfs(List<Edge>[] adjList, int i) {
        visited[i] = true;
        System.out.print(i+" ");
        for(Edge e: adjList[i]) {
            if(!visited[e.adjvertex]) {
                dfs(adjList, e.adjvertex);
            }
        }
    }
}