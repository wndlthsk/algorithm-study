// 대각선 오른쪽 아래 or 왼쪽 아래
// i, j = max(i-1, j-1 , i-1, j+1)

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i=1; i<n; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                dp[i][j] = triangle[i][j]
                    + Math.max(
                    i-1 >=0 && j-1 >=0 ? dp[i-1][j-1] : 0,
                    i-1 >=0 && j < triangle[i].length ? dp[i-1][j] : 0
                );
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }
}