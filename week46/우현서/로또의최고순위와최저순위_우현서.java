// 1~45 중 6개
// 알아볼 수 없는 수를 0으로 표기

import java.util.HashSet;
import java.util.Set;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        for (int w: win_nums) {
            winSet.add(w);
        }

        int count0 = 0;
        int count = 0;
        for (int l: lottos) {
            if (l == 0) {
                count0++;
                continue;
            }
            if (winSet.contains(l)) count++;
        }

        int max = Math.min(6, 7 - (count + count0));
        int min = Math.min(6, 7 - count);

        return new int[]{max, min};
    }
}