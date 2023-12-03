public class AllPairsShortestPath {
    public AllPairsShortestPath() {
    }

    public void findAllPairShortestPath(int[][] graph, int n) {
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                if(i == k) continue;
                for(int j=0;j<n;j++) {
                    if(j == k || j == i) continue;
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }
        for(int[] i: graph) {
            for(int num: i) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
