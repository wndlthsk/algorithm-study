// 1번: 12345
// 2번: 21232425
// 3번: 3311224455
// answer: 1번부터마지막 문제까지의 정답
// 가장 많이맞힌사람 배열 리턴, 여러명이면 오름차순

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {

        int[][] patterns = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };

        int[] correct = new int[3];
        int max = 0;
        for (int i=0; i<3; i++) {
            int cnt = 0;
            for (int j=0; j<answers.length; j++) {
                int idx = j % patterns[i].length;
                if (answers[j] == patterns[i][idx]) cnt++;
            }
            correct[i] = cnt;
            max = Math.max(max, cnt);
        }
        // System.out.println(Arrays.toString(correct));

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (correct[i] == max) {
                result.add(i+1);
            }
        }
        // Collections.sort(result);
        // System.out.println(result);

        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}