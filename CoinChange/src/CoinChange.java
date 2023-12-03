import java.util.Scanner;

// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class CoinChange {
    public static void main(String[] args) {
        int money = 3215;
        System.out.println("500 : "+money/500);
        money %= 500;
        System.out.println("100 : "+money/100);
        money %= 100;
        System.out.println("50: "+money/50);
        money %= 50;
        System.out.println("10: "+money/10);
        money %= 10;
        System.out.println("잔돈 : "+money);
    }
}