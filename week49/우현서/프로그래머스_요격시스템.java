// 필요한 요격 미사일 최솟값 리턴
// e로 오름차순 정렬, 필요한 개수 카운트

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        // System.out.println(Arrays.deepToString(targets));

        int k = Integer.MIN_VALUE;

        for (int[] target: targets) {
            if (target[0] >= k) {
                answer++;
                k = target[1];
            }
        }

        return answer;
    }
}