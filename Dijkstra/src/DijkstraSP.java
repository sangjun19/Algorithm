import java.util.List;

public class DijkstraSP {
    public int N;
    List<Edge>[] graph;
    public int[] previous;
    public DijkstraSP(List<Edge>[] adjList) { //생성자
        N = adjList.length;
        previous = new int[N];
        graph = adjList;
    }
    public int[] shortestPath(int s) {
        boolean[] visited = new boolean[N]; //방문 여부
        int[] D = new int[N]; //가중치
        for(int i=0;i<N;i++) { //초기화
            visited[i] = false;
            previous[i] = -1;
            D[i] = Integer.MAX_VALUE;
        }
        previous[s] = 0;
        D[s] = 0; //시작점
        for(int k=0;k<N;k++) { //엣지 수만큼
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<N;j++) {
                if((!visited[j]) && D[j]<min) { //방문하지 않은 정점중 작은 D
                    min = D[j];
                    minVertex = j;
                }
            }
            visited[minVertex] = true;
            for(Edge e: graph[minVertex]) {
                if(!visited[e.adjvertex]) {
                    int currentDist = D[e.adjvertex];
                    int newDist = D[minVertex] + e.weight;
                    if(newDist<currentDist) {
                        D[e.adjvertex] = newDist;
                        previous[e.adjvertex] = minVertex;
                    }
                }
            }
        }
        return D;
    }
}
