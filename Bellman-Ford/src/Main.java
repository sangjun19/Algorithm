public class Main {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] weight = {    // [�׸� 9-5-6](a)�� �Է±׷���
                { INF,   1, INF,   2, INF, INF, INF, INF},
                { INF, INF,   4,  -2,   1,   6, INF, INF},
                { INF, INF, INF, INF, INF, INF, INF,   2},
                { INF, INF, INF, INF,  -1, INF, INF, INF},
                { INF, INF, INF, INF, INF, INF,   4, INF},
                { INF, INF,   1, INF, INF, INF, INF, INF},
                { INF, INF,  -1, INF, INF, INF, INF,   1},
                { INF, INF, INF, INF, INF,   3, INF, INF}
        };
        int N = weight.length; // �׷��� ������ ��

        int s = 0; // �����
        BellmanFord bf = new BellmanFord(N);  // ��ü ����
        bf.shortestPath(s, weight);  		  // �ִ� ��� ã��
        bf.printPaths(s);            		  // ��� ���
    }
}
