import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int N = 12;
        int[] num = new int[N];
        Random random = new Random();
        for(int i=0; i<N; i++) {
            num[i] = random.nextInt(10000)+1;
        }
//        num[0] = 6;
//        num[1] = 3;
//        num[2] = 11;
//        num[3] = 9;
//        num[4] = 12;
//        num[5] = 2;
//        num[6] = 8;
//        num[7] = 15;
//        num[8] = 18;
//        num[9] = 10;
//        num[10] = 7;
//        num[11] = 14;
        System.out.println(Arrays.toString(num));
        Selection selection = new Selection();
        int k = 7;
        System.out.println(k+"번째 숫자 : "+selection.selec(num, 0, N-1, k));
    }
}