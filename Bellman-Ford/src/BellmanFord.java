public class BellmanFord {
    public static int INF = Integer.MAX_VALUE;
    private int D[];
    private int previous[];
    private int N;

    public BellmanFord(int numOfvertices) {
        N = numOfvertices; //정점의 개수
        D = new int[N]; //거리
        previous = new int [N];
    }

    public void shortestPath(int s, int adjMatrix[][]) {
        for(int i=0;i<N;i++) D[i] = INF; //초기화
        D[s] = 0;
        previous[s] = 0;
        for(int k=0;k<1;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(adjMatrix[i][j]!=INF) { //엣지 연결 여부
                        if(D[j]>D[i]+adjMatrix[i][j]) { //현재 거리보다 새로운 거리가 작을때
                            D[j] = D[i] + adjMatrix[i][j];
                            previous[j] = i;
                        }
                    }
                }
//                System.out.println("--------\ni = "+i);
//                printPaths(0);
            }

        }
    }

    public void printPaths(int s) {
        System.out.println("정점 "+s+"으로부터의 최단 거리");

        for(int i=0;i<D.length;i++) {
            if(D[i] == Integer.MAX_VALUE)
                System.out.println(s+"과"+i+" 사이에 경로 없음.");
            else
                System.out.println("["+s+", "+i+"] = "+D[i]);
        }
        System.out.print("\n정점 "+s+"으로부터의 최단 경로\n");
        for(int i=1;i<N;i++) {
            int back = i;
            System.out.print(back);
            while(back!=0) {
                System.out.print("<-"+previous[back]);
                back = previous[back];
            }
            System.out.println();
        }
    }
}
