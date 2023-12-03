import java.util.List;

public class PrimMST {
    int N;
    List<Edge>[] graph;

    public PrimMST(List<Edge>[] adjList) {
        N = adjList.length;
        graph = adjList;
    }

    public int[] mst (int s) {
        boolean[] visited = new boolean[N];
        int[] D = new int[N];

        int[] previous = new int [N];
        for(int i=0;i<N;i++) {
            visited[i] = false;
            previous[i] = -1;
            D[i] = Integer.MAX_VALUE;
        }
        previous[s] = 0;
        D[s] = 0;

        for(int k=0;k<N;k++) {
            int minVertex = -1;
            int min = Integer.MAX_VALUE;

            for(int j=0;j<N;j++) {
                if((!visited[j]) && (D[j]<min)) {
                    min = D[j];
                    minVertex = j;
                }
            }
            System.out.println("minVertex : "+minVertex);
            visited[minVertex] = true;

            for(Edge i: graph[minVertex]) {
                if(!visited[i.adjvertex]) {
                    int currentDist = D[i.adjvertex];
                    int newDist = i.weight;
                    if(newDist < currentDist) {
                        D[i.adjvertex] = newDist;
                        previous[i.adjvertex] = minVertex;
                        System.out.print("previous : ");
                        for(int x=0;x<N;x++) {
                            System.out.print(previous[x] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
        return previous;
    }
}
