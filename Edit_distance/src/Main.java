// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class Main {
    public static void main(String[] args) {
        String S = "strong";
        String T = "stone";
        int m = S.length();
        int n = T.length();
        Edit_distance(S, T, m, n);
    }

    public static void Edit_distance(String S, String T, int m, int n) {
        int E[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            E[i][0] = i;
        }
        for(int j=0;j<=n;j++) {
            E[0][j] = j;
        }
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                int a = 0;
                if((S.charAt(i-1) != T.charAt(j-1))) a = 1;
                int temp = Math.min(E[i][j-1]+1, E[i-1][j]+1);
                E[i][j] = Math.min(temp, E[i-1][j-1]+a);
            }
        }
        for(int[] a : E) {
            for(int b: a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        //return E[m-1][n-1];
    }
}