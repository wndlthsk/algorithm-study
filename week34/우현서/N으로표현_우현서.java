// n과 사칙연산으로 표현할 수 있는 방법 중 n을 최소로 사용
// 최소 사용횟수 구하기
// 최솟값이 8보다 크면 -1리턴

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatedN);

            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}