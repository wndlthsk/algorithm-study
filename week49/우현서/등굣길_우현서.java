// nxm, (1,1) -> (m,n)
// 최단경로의 개수 % 1,000,000,007

// 위, 왼쪽에서 올수 있음
// dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];

        for (int[] p: puddles) {
            dp[p[1]][p[0]] = -1;
        }

        dp[1][1] = 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (i == 1 && j == 1) continue;

                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
            }
        }

        return dp[n][m];
    }
}