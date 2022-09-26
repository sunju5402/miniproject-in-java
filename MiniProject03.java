/*
이선주
*/
import java.util.Scanner;

public class MiniProject03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int time = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        char c1 = sc.next().charAt(0);
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        char c2 = sc.next().charAt(0);

        int fee = 10000;
        if (age < 3) {
            fee = 0;
        } else if (age < 13) {
            fee = 4000;
        } else {
          if (time >= 17) {
              fee = 4000;
          } else {
              if (c1 == 'y' || c2 == 'y') {
                  fee = 8000;
              }
          }
        }
        System.out.println("입장료: " + fee);
    }
}