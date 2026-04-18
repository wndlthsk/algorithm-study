// 같은 행중 한칸 밟으면서 내려옴
// 같은 열을 연속해서 밟을 수 x
// 얻을 수 있는 점수의 최댓값 리턴

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

        int answer = 0;

        for (int i=0; i<4; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }


        return answer;
    }
}