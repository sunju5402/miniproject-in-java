/*
달력 출력
*/
import java.util.Calendar;
import java.util.Scanner;

public class MiniProject05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        System.out.println("\n\n[" + year + "년 " + String.format("%02d", month) + "월]");
        String[] days = { "일", "월", "화", "수", "목", "금", "토" };

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        for (String day : days) {
            System.out.print(day + "\t");
        }
        System.out.println();

        int cnt = 0;
        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < startDay; i++) {
            System.out.print("\t");
            cnt++;
        }

        int start = cal.getMinimum(Calendar.DATE);
        int end = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = start; i <= end; i++) {
            if (cnt == 7){
                System.out.println();
                cnt = 0;
                System.out.printf("%02d\t", i);
                cnt++;
            }
            else {
                System.out.printf("%02d\t", i);
                cnt++;
            }
        }
    }
}
