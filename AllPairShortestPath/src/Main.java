// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class Main {
    public static void main(String[] args) {
        int INF = 9999;
        int graph[][] = {
                {0, INF, 2, INF},
                {1, 0, INF, INF},
                {INF, 8, 0, 3},
                {6, 4, INF, 0}
        };
        int n = 4;
        AllPairsShortestPath a = new AllPairsShortestPath();
        a.findAllPairShortestPath(graph, n);
// 최단 거리 행렬을 계산한 후 출력한다
    }
}