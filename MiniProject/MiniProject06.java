import java.util.Random;

public class MiniProject06 {
    public static void main(String[] args) {
        Random rd = new Random();

        final int TotalVote = 10000;
        int[] candidate = new int[4];
        String[] name = {"이재명", "윤석열", "심상정", "안철수"};
        int maxIdx = 0;
        for (int i = 1; i <= TotalVote; i++) {
            int idx = rd.nextInt(4);
            candidate[idx]++;
            System.out.printf("[투표진행율]: %.2f%s, %d명 투표 => %s\n", (double)i / TotalVote * 100, '%', i, name[idx]);
            for (int j = 0; j < name.length; j++) {
                System.out.printf("[기호:%d] %s: %.2f%s, (투표수: %d)\n", j + 1, name[j], (double)candidate[j] / TotalVote * 100, '%', candidate[j]);
            }

            if (i == TotalVote) {
                int maxVote = 0;
                maxIdx = 0;
                for (int j = 0; j < candidate.length; j++) {
                    if (maxVote < candidate[j]) {
                        maxVote = candidate[j];
                        maxIdx = j;
                    }
                }

                boolean isSameVote = false; // 최다득표자가 여러명일 경우, 그수만큼 다시 투표하도록 한다.
                for (int j = 0; j < candidate.length; j++) {
                    if (maxIdx == j) {
                        continue;
                    }

                    if (maxVote == candidate[j]) {
                        candidate[j]--;
                        i--;
                        isSameVote = true;
                    }
                }

                if (isSameVote) {
                    candidate[maxIdx]--;
                    i--;
                }
            } else {
                System.out.println();
            }
        }
        System.out.println("[투표결과] 당선인: " + name[maxIdx]);
    }
}
