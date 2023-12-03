import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] coins = {16, 10, 5, 1};
        int N = 20;
        int[] result = make_change(N, coins);
        for(int i=0;i<coins.length;i++) {
            System.out.println(coins[i] + "동전의 수 : " + result[i+1]);
        }
    }
    public static int[] make_change(int N, int[] coins) {
        int[] C = new int[N+1];
        int k = coins.length;
        int[][] cnt = new int[N+1][k+1];

        for(int i=1;i<=N;i++) C[i] = Integer.MAX_VALUE;
        for(int j=1;j<=N;j++) {
            for(int i=1;i<=k;i++) {
                if(coins[i-1]<=j && (C[j-coins[i-1]]+1<C[j])) { // 거스름돈 보다 동전이 적거나 같고 현재 금액-현재 선택한 동전 차액에 필ㄹ요한 동전의 개수가 현재 금액에 필요한 동전 수보다 작아야함
                    C[j] = C[j-coins[i-1]] + 1;

                    cnt[j] = cnt[j-coins[i-1]].clone();
                    cnt[j][i]++;
                }
            }
        }
        return cnt[N];
    }
}