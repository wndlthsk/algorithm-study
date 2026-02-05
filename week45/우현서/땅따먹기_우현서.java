// n행 4열, 모든 칸에 점수
// 1행부터 한행씩 내려올때 4칸 중 한칸만 밟아야함
// 같은 열을 연속해서 밟기는 불가능
// i,j = land[i][j] + max(i-1, k)

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        for (int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<4; j++) {
                int max = 0;
                for (int k=0; k<4; k++) {
                    if (j == k) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + max;
            }
        }

        int result = 0;
        for (int i=0; i<4; i++) {
            result = Math.max(result, dp[n-1][i]);
        }

        return result;
    }
}