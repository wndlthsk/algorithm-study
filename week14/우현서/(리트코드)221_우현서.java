// mxn, 0 또는 1로 채워져 있음
// 1로만 구성된 가장 큰 정사각형의 면적 리턴

// dp[i][j] : matrix[i][j]까지 최대 정사각형의 가로 길이
// dp[i][j] = 현재 위치의 왼쪽 대각선 위, 위쪽, 왼쪽 중 가장 짧은 길이에 + 1
//          = min(dp[i-1][j-1], dp[i-1][j], dp[j-1][i]) + 1

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; // 행
        int n = matrix[0].length; // 열
        // System.out.println(n + " " + m);

        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i=0; i<n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                int now = matrix[i][j] - '0';
                if (now == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));

        int maxLen = Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
        // System.out.println(maxLen);

        return maxLen * maxLen;
    }
}