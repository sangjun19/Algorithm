// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 1, 100};
        int size = arr.length;

        System.out.println("동적 계획을 이용한 최소 곱셈 횟수: " + MatrixChainMultiplication(arr, size));
    }

    public static int MatrixChainMultiplication(int[] arr, int size) {
        int[][] C = new int[size][size];
        int n = size-1;
        for(int i=0;i<=n;i++) {
            C[i][i] = 0;
        }
        for(int l=1;l<=n-1;l++) {
            for(int i=1;i<=n-l;i++) {
                int j = i+l;
                C[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++) {
                    int temp = C[i][k] + C[k+1][j] + (arr[i-1]*arr[k]*arr[j]);
                    if(temp < C[i][j]) C[i][j] = temp;
                }
            }
        }
        return C[1][n];
    }
}