// mxn
// 최단 경로 개수 1,000,000,007로 나눈 나머지 구하기


class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int[] p: puddles) {
            dp[p[0]][p[1]] = -1;
        }
        // System.out.println(Arrays.deepToString(dp));

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (i==1 && j==1) continue;
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        return dp[m][n];
    }
}