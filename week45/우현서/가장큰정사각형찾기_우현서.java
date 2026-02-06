// 1로 이루어진 가장 큰 정사각형의 넓이 리턴
// dp[i][j] : 현재 좌표까지 가장 큰 정사각형의 길이
// = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1


class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;

        int[][] dp = new int[n][m];
        for (int i=0; i<n; i++){
            dp[i][0] = board[i][0];
        }
        for (int j=0; j<m; j++) {
            dp[0][j] = board[0][j];
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (board[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        // System.out.println(Arrays.deepToString(dp));

        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}