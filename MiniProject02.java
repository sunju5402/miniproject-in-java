/*
이선주
*/
import java.util.Scanner;
public class MiniProject02 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");

        Scanner sc = new Scanner(System.in);
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int price = sc.nextInt();
        int cashback = price / 10;
        cashback -= cashback % 100;

        if (cashback > 300) {
            cashback = 300;
        }
      
        System.out.println("결제 금액은 " + price + "원이고, 캐시백은 " + cashback + "원 입니다.");
    }
}
