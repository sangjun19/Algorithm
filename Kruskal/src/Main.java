import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[][] weight = {
                {  0,  9, 10,  0, 0, 0, 0},
                {  9,  0,  0 ,10, 5, 0, 3},
                { 10,  0,  0,  9, 7, 2, 0},
                {  0, 10,  9,  0, 0, 4, 8},
                {  0,  5,  7,  0, 0, 0, 1},
                {  0,  0,  2,  4, 0, 0, 6},
                {  0,  3,  0,  8, 1, 6, 0},
        };
        int N = weight.length;
        int M = 0;
        List<Edge>[] adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (weight[i][j] != 0) {
                    Edge e = new Edge(i,j, weight[i][j]);
                    adjList[i].add(e);
                    M++; // 엣지의 수
                }
            }
        }
        KruskalMST k = new KruskalMST(adjList, M);
        Edge[] tree;
        System.out.print("최소 신장 트리 간선: ");
        tree = k.mst();

        int sum = 0;
        for (int i = 0; i < tree.length; i++) {
            System.out.print("("+tree[i].vertex + "," +tree[i].adjvertex+ ") ");
            sum += tree[i].weight;
        }
        System.out.printf("\n\n");
        System.out.println("최소 신장 트리의 간선 가중치 합 = "+sum);
    }
}
