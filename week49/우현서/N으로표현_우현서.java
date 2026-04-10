// n과 사칙 연산 사용해서 number 만들기
// n의 최소 사용 횟수
// 8보다 크면 -1 리턴

// dp[i] = n을 i번 써서 만들 수 있는 숫자 조합

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        for (int i=2; i<=8; i++) {
            int nn = 0;
            int k = 1;
            for (int j=1; j<=i; j++) {
                nn += N * k;
                k *= 10;
            }
            // System.out.println("i: " + i + " nn: " + nn);
            dp.get(i).add(nn);

            for (int a=1; a<i; a++) {
                int b = i-a;

                for (int x: dp.get(a)) {
                    for (int y: dp.get(b)) {
                        dp.get(i).add(x + y);
                        dp.get(i).add(x - y);
                        dp.get(i).add(x * y);
                        if (y!=0) dp.get(i).add(x / y);
                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}