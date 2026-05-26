// 최대한 많은 부서의 물품 구매

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;


        Arrays.sort(d);

        int sum = 0;
        for (int cost: d) {
            if (sum + cost > budget) break;

            sum += cost;
            answer++;

        }

        return answer;
    }
}