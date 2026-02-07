// 각 단어 조각은 무한대
// 주어진 문장 완성하기 위해 사용해야하는 개수의 최솟값 리턴
// 불가능하면 -1

// 문자열의 각 자릿수까지 필요한 조각 개수의 최솟값을 누적하면서
// dp[i] : i글자까지 만들기 위한 최소 조각 개수

import java.util.Arrays;

class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;

        int n = t.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;

        for (int i=1; i<=n; i++) {
            for (String s: strs) {
                int len = s.length();
                if (len > i) continue;

                if (t.substring(i-len, i).equals(s)) {
                    dp[i] = Math.min(dp[i], dp[i-len] + 1);
                }
            }
        }

        // System.out.println(Arrays.toString(dp));

        if (dp[n] == n+1) return -1;
        else return dp[n];
    }
}