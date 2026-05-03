// 흔적 최소화
// A는 n개 이상, B는 m개 이상이면 잡힘
// A의 흔적 누적 개수 최솟값 구하기
// 둘다 붙잡히게 되면 -1 리턴

// dp[i][j] : i번째 물건을 훔칠 때 B의 흔적이 j일때 A 흔적의 최소값
// dp[i][j] = min(dp[i][j], dp[i-1][j]+info[i][0]) // A가 가져감
// dp[i][j+info[i][1]] = min(dp[i][j+info[i][1]], dp[i-1][j]) // B가 가져감

import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {

        int[][] dp = new int[info.length][m];
        for (int i=0; i<info.length; i++) {
            Arrays.fill(dp[i], n);
        }

        if (info[0][0] < n) dp[0][0] = info[0][0];
        if (info[0][1] < m) dp[0][info[0][1]] = 0;

        for (int i=1; i<info.length; i++) {
            for (int j=0; j<m; j++) {
                if (dp[i-1][j]+info[i][0] < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+info[i][0]);
                }

                if (j+info[i][1] < m) {
                    dp[i][j+info[i][1]] = Math.min(dp[i][j+info[i][1]], dp[i-1][j]);
                }
            }
        }

        int answer = n;
        for (int x: dp[info.length-1]) {
            answer = Math.min(answer, x);
        }

        return answer == n ? -1 : answer;
    }
}