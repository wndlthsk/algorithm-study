// 구매했던 로또의 당첨 가능한 최고 순위, 최저 순위
// 0: 알아볼 수 없는 번호
// 순서 상관없이 일치 번호가 있으면 읹넝

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        Set<Integer> wins = new HashSet<>();
        for (int n: win_nums) {
            wins.add(n);
        }

        int count = 0;
        int count0 = 0;
        for (int n: lottos) {
            if (n == 0) count0++;
            else if (wins.contains(n)) count++;
        }

        int min = rank(count);
        int max = rank(count + count0);
        int[] answer = {max, min};

        return answer;
    }

    public int rank(int num) {
        if (num >= 6) return 1;
        else if (num == 5) return 2;
        else if (num == 4) return 3;
        else if (num == 3) return 4;
        else if (num == 2) return 5;
        else if (num < 2) return 6;

        return -1;
    }
}