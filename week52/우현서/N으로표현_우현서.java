// n 사용횟수의 최솟값 구하기
// 8보다 크면 -1 리턴

// dfs?

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);
        for (int i=1; i<=8; i++) {
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeated);

            for (int j = 1; j < i; j++) {

                for (int a : dp.get(j)) {
                    for (int b : dp.get(i-j)) {

                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b==0) continue;
                        dp.get(i).add(a / b);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }


        return -1;
    }
}