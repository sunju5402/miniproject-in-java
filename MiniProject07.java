/*
로또 당첨 프로그램
*/

import java.util.*;

public class MiniProject07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또의 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int num = sc.nextInt();
        while(num < 1 || num > 10) {
            System.out.println("조건에 맞게 다시 입력하세요!");
            System.out.print("로또의 개수를 입력해 주세요.(숫자 1 ~ 10):");
            num = sc.nextInt();
        }

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        char idx = 'A';
        ArrayList<Integer> list;
        for (int i = 0; i < num; i++) {
            list = randomSortedList();

            System.out.print(idx + "\t");
            printInfo(list);
            System.out.println();

            map.put(idx, list);
            idx++;
        }

        System.out.println("\n[로또 발표]");
        ArrayList<Integer> lotto = randomSortedList();

        System.out.print("\t");
        printInfo(lotto);
        System.out.println();

        System.out.println("\n[내 로또 결과]");
        Iterator<Character> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            char key = keys.next();
            System.out.print(key + "\t");
            printInfo(map.get(key));
            int result = calSameNum(map.get(key), lotto);
            System.out.println(" => " + result + "개 일치");
        }
    }

    public static ArrayList<Integer> randomSortedList() {
        Random rd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(rd.nextInt(45) + 1);
            /*
            for (int j = 0; j < i; j++) { // 랜덤중복제거
                if (list.get(i) == list.get(j)) {
                    list.remove(i);
                    i--;
                }
            }*/
            
        //중복 숫자를 뽑은 다음에 다시 빼지 말고, 이미 뽑은 숫자에 대해서는 다음에 뽑을때 뽑히지 않도록 하는 방법 
        int num;
        boolean isSame;
        for (int i = 0; i < 6; i++) {
            isSame = false;
            num = rd.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (list.get(j) == num) {
                    i--;
                    isSame = true;
                    break;
                }
            }
            if (!isSame) {
                list.add(num);
            }
        }
        Collections.sort(list);

        return list;
    }
    public static void printInfo(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.printf("%02d", list.get(i));
                break;
            }
            System.out.printf("%02d,", list.get(i));
        }
    }

    public static int calSameNum(ArrayList<Integer> list, ArrayList<Integer> lotto) {
        int result = 0;
        int idx = 0;
        for (int i = 0; i < lotto.size(); i++) {
            for (int j = idx; j < list.size(); j++) {
                if (list.get(j) == lotto.get(i)) {
                    result++;
                    idx = j + 1;
                    break;
                }
            }
        }
        return result;
    }
}
