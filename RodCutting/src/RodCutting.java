// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class RodCutting {

    public static int cutRod_DC(int[] A, int size) {
        if(size == 0) return 0;
        int max = 0;
        for(int i=1;i<size;i++) max = Math.max(max, A[i] + cutRod_DC(A, size - i));
        return max;
    }

    public static int cutRod_DP(int A[], int size) {
        int[] maxSell = new int[size];
        maxSell[0] = 0;
        for(int j=1;j<size;j++) {
            int maxVal = 0;
            for(int k=1;k<=j;k++) maxVal = Math.max(maxVal, A[k] + maxSell[j-k]);
            maxSell[j] = maxVal;
            //System.out.println(maxSell[j]);
        }
        return maxSell[size-1];
    }

    public static void main(String[] args) {
        int[] A = new int[] {0, 2, 5, 9, 10};
        int size = A.length;
        System.out.println("분할 정복을 이용하여 구한 최대 판매 금액: " + cutRod_DC(A, size));
        System.out.println("동적 계획을 이용하여 구한 최대 판매 금액: " + cutRod_DP(A, size));
    }
}