// dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        // System.out.println(n);

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i=1; i<n; i++) {
            int m = triangle[i].length;
            for (int j=0; j<m; j++) {
                dp[i][j] = triangle[i][j];

                if (j == 0) {
                    dp[i][j] += dp[i-1][j];

                } else if (j > 0 && j < m-1) {
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);;

                } else if (j == m-1) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        int answer = 0;

        // System.out.println(Arrays.deepToString(dp));
        for (int x: dp[n-1]) {
            answer = Math.max(answer, x);
        }

        return answer;
    }
}