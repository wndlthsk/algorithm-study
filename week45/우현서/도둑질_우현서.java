// 인접한 두집을 털면 경보가 울림
// 0번째 집을 턴다/만다
// dp[i] = max(dp[i-1], dp[i-2] + x)

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        int[] dp1 = new int[n];
        // dp1[n-1] = 0;
        dp1[0] = money[0];
        dp1[1] = money[0];
        for (int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }

        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i=2; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));

        return Math.max(dp1[n-2], dp2[n-1]);
    }
}