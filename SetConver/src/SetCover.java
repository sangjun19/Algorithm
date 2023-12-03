import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class SetCover {
    public static void main(String[] args) {
       //int[] U = {1, 2, 4, 5, 6, 7, 8, 9, 10};
       Set<Integer> U = new HashSet<>(10);
       for(int i=0;i<10;i++) U.add(i+1);
       int[] s1 = {1, 2, 3, 8};
       int[] s2 = {1, 2, 3, 4, 8};
       int[] s3 = {1, 2, 3, 4};
       int[] s4 = {2, 3, 4, 5, 7, 8};
       int[] s5 = {4, 5, 6, 7};
       int[] s6 = {5, 6, 7, 9, 10};
       int[] s7 = {4, 5, 6, 7};
       int[] s8 = {1, 2, 4, 8};
       int[] s9 = {6, 9};
       int[] s10 = {6, 10};
       int[][] F = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};

       HashSet<Integer> set = new HashSet<>();
       ArrayList<Integer> collect = new ArrayList<>();

        do {
            int max = 0;
            int index = 0;
            for (int i = 0; i < 10; i++) {
                if (max < (overLap(F[i], U))) {
                    max = overLap(F[i], U);
                    index = i;
                }
            }
            collect.add(index+1);
            for (int n : F[index]) {
                set.add(n);
                U.remove(n);
            }
            F[index] = new int[0];
        } while (set.size() <= 9);
        System.out.println(collect);
    }

    private static int overLap(int[] ints, Set<Integer> u) {
        int cnt = 0;
        for(int n: ints) {
            for(int x: u) {
                if(n == x) cnt++;
            }
        }
        return cnt;
    }
}