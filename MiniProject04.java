import java.util.Random;
import java.util.Scanner;

public class MiniProject04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        String regNum = "";

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        int month = sc.nextInt();
        System.out.print("출생일을 입력해 주세요.(dd):");
        int date = sc.nextInt();
        System.out.print("성별을 입력해 주세요.(m/f):");
        char gender = sc.next().charAt(0);

        int gen = 0;
        if (year < 2000) {
            if (gender == 'm') {
                gen = 1;
            } else {
                gen = 2;
            }
        } else {
            if (gender == 'm') {
                gen = 3;
            } else {
                gen = 4;
            }
        }
        regNum = year + String.format("%02d", month) +
                String.format("%02d", date) + "-" + gen +
                (rd.nextInt(100000) + 100000);

        System.out.println(regNum);
    }
}
