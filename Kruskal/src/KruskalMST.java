import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMST {
    int N, M;
    List<Edge>[] graph;
    UnionFind uf;
    Edge[] tree;

    static class Weight_Comparison implements Comparator<Edge> { //가중치 비교 함수
        public int compare(Edge e, Edge f) {
            if(e.weight > f.weight)
                return 1;
            else if(e.weight < f.weight)
                return -1;
            return 0;
        }
    }

    public KruskalMST(List<Edge>[] adjList, int numOfEdges) {
        N = adjList.length; //버텍스의 수
        M = numOfEdges; //엣지의 수
        graph = adjList;
        uf = new UnionFind(N);
        tree = new Edge[N-1];
    }

    public Edge[] mst() {
        Weight_Comparison BY_WEIGHT = new Weight_Comparison();
        PriorityQueue<Edge> pq = new PriorityQueue<>(M, BY_WEIGHT);

        for(int i=0;i<N;i++) {
            for(Edge e: graph[i]) {
                pq.add(e);
            }
        }
        int count = 0;
        while(!pq.isEmpty() && count < N-1) {
            Edge e = pq.poll();
            int u = e.vertex;
            int v = e.adjvertex;
            if(!uf.isConnected(u, v)) {
                uf.union(u, v);
                tree[count++] = e;
            }
        }
        return tree;
    }
}
