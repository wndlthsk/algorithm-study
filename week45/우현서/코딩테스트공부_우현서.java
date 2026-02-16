// 알고력, 코딩력
// 알고력 1 높이려면 1 시간 필요
// 코딩력 1 높이려면 1 시간 필요
// 문제를 풀어 알고력/코딩력 올릴 수 있음
// 문제 푸는 시간 o, 같은 문제 여러번 풀수 있음
// 모든 문제를 푸는 알고력과 코딩력을 얻는 최단 시간 구하기

// alp: 알고력
// cop: 코딩력
// problems: 문제 정보  [alp_req, cop_req, alp_rwd, cop_rwd, cost]

import java.util.Arrays;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        // 모든 문제 푸는데 필요한 알고력, 코딩력
        int maxa = 0;
        int maxc = 0;
        for (int[] p: problems) {
            maxa = Math.max(maxa, p[0]);
            maxc = Math.max(maxc, p[1]);
        }

        alp = Math.min(alp, maxa);
        cop = Math.min(cop, maxc);

        int[][] dp = new int[maxa+1][maxc+1]; // dp[a][c] : a, c까지 최소 시간
        for (int a=0; a<=maxa; a++) {
            Arrays.fill(dp[a], Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;

        for (int a=alp; a<=maxa; a++) {
            for (int c=cop; c<=maxc; c++) {
                int cur = dp[a][c];
                if (cur == Integer.MAX_VALUE) continue;

                if (a+1<=maxa) dp[a+1][c] = Math.min(dp[a+1][c], cur+1);
                if (c+1<=maxc) dp[a][c+1] = Math.min(dp[a][c+1], cur+1);

                for (int[] p: problems) {
                    if (a >= p[0] && c >= p[1]) {
                        int na = Math.min(maxa, a+p[2]);
                        int nc = Math.min(maxc, c+p[3]);
                        dp[na][nc] = Math.min(dp[na][nc], cur+p[4]);
                    }
                }
            }
        }

        return dp[maxa][maxc];
    }
}