// 둘다 안잡힐때 A의 최소 흔적 누적 개수 리턴, 둘다 안 붙잡히게 못하면 -1 리턴

// dfs -> 시간 초과
// dp[i][j] : i번째 물건을 훔칠 때 B의 흔적이 j일때 A 흔적의 최소값
// dp[i][j] = min(dp[i-1][j] + a, dp[i][j])
// dp[i][j+b] = min(dp[i-1][j], dp[i][j+b])

import java.util.Arrays;

class Solution {

    public int solution(int[][] info, int n, int m) {
        int stuff = info.length;

        int[][] dp = new int[stuff][m];
        for (int i = 0; i < stuff; i++) {
            Arrays.fill(dp[i], n);
        }
        // 0번 물건 처리
        if (info[0][0] < n) dp[0][0] = info[0][0];
        if (info[0][1] < m) dp[0][info[0][1]] = 0;

        for (int i=1; i<stuff; i++) {
            for (int j=0; j<m; j++) {
                // i번 물건을 A가 훔침
                if (dp[i-1][j] + info[i][0] < n) {
                    dp[i][j] = Math.min(dp[i-1][j] + info[i][0], dp[i][j]);
                }

                // i번 물건을 B가 훔침
                if (j+info[i][1] < m) {
                    dp[i][j+info[i][1]] = Math.min(dp[i-1][j], dp[i][j+info[i][1]]);
                }
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        int minA = n;
        for (int a: dp[stuff-1]) minA = Math.min(minA, a);

        if (minA == n) return -1;
        else return minA;
    }

// dfs -> 시간 초과
//     int minA = Integer.MAX_VALUE;

//     public void dfs(int idx, int a, int b) {
//         if (a >= n) return;
//         if (b >= m) return;

//         if (idx == stuff) {
//             minA = Math.min(minA, a);
//             return;
//         }

//         dfs(idx+1, a+info[idx][0], b);
//         dfs(idx+1, a, b+info[idx][1]);
//     }
}