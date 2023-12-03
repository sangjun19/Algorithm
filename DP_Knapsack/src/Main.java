public class Main {
    public static void main(String[] args) {
        int[] value = {25, 15, 20, 30};
        int[] weight = {3, 1, 2, 4};
        int C = 7;
        int n = value.length;
        System.out.println("최대 가치 = " + knapSack(C, weight, value, n));
    }

    public static int knapSack(int C, int[] weight, int[] value, int n) {
        int[][] K = new int[n+1][C+1];
        for(int i=0;i<=n;i++) K[i][0] = 0;
        for(int w=0;w<=C;w++) K[0][w] = 0;
        for(int i=1;i<=n;i++) {
            for(int w=1;w<=C;w++) {
                System.out.println("i : " + i);
                if(weight[i-1] > w) K[i][w] = K[i-1][w];
                else K[i][w] = Math.max(K[i-1][w], K[i-1][w-weight[i-1]]+value[i-1]);
            }
        }
        return K[n][C];
    }
}