import java.util.Scanner;

public class MiniProject08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        int annualIncome = sc.nextInt();
        int clone = annualIncome;

        int[] incomeArr = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        int[] difIncomeArr = new int[incomeArr.length];
        difIncomeArr[0] = incomeArr[0];
        for (int i = 1; i < incomeArr.length; i++) {
            difIncomeArr[i] = incomeArr[i] - incomeArr[i-1];
        }
        double[] taxRate = {0.06, 0.15, 0.24, 0.35, 0.38, 0.40, 0.42, 0.45};
        int tax1 = 0;

        int tax2 = 0;
        int[] arr = {1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

        int idx = -1;
        for (int i = 0; i < incomeArr.length; i++) {
            if (annualIncome < incomeArr[i]) {
                idx = i;
                break;
            }
        }

        int result = 0;
        if (idx == -1) {idx = difIncomeArr.length;} // 10억 초과할때
        for (int i = 0; i < idx; i++) {
            result = (int)(difIncomeArr[i] * taxRate[i]);
            tax1 += result;
            System.out.printf("%10d * %2d%s = %10d\n", difIncomeArr[i], (int)(taxRate[i] * 100), '%', result);
            clone -= difIncomeArr[i];
        }
        result = (int)(clone * taxRate[idx]);
        tax1 += result;
        System.out.printf("%10d * %d%s = %10d\n", clone, (int)(taxRate[idx] * 100), '%', result);

        if (idx == 0) {
            tax2 = (int)Math.round(annualIncome * taxRate[idx]);
        } else {
            tax2 = (int)Math.round(annualIncome * taxRate[idx]) - arr[idx - 1];
        }
        System.out.println("\n[세율에 의한 세금]:\t\t\t" + tax1);
        System.out.println("[누진공제계산에 의한 세금]:\t" + tax2);
    }
}
