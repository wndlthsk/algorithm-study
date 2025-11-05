// 물에 안 잠긴 지역으로 학교 가기
// 가는 길 크기 mxn
// (1, 1) -> (m, n)
// 오른쪽, 아래쪽으로만 움직여 갈 수 있는 최단 경로 개수를 1,000,000,007로 나눈 나머지 리턴
// puddles: 물에 잠긴 좌표

// dp[i][j] : i,j에 올 수 있는 경우의 수
// dp[i][j] = dp[i-1][j] + dp[i][j-1]


class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];

        dp[1][1] = 1;
        for (int[] p: puddles) {
            dp[p[1]][p[0]] = -1;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (dp[i][j] == -1 || (i == 1 && j == 1)) continue;

                int up = (dp[i-1][j] == -1 ? 0 : dp[i-1][j]);
                int left = (dp[i][j-1] == -1 ? 0 : dp[i][j-1]);

                dp[i][j] = (up + left) % 1000000007;
            }
        }

        answer = dp[n][m];
        return answer;
    }
}