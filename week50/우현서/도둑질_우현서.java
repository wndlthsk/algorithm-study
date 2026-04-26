// 도둑이 훔칠 수 있는 돈의 최댓값 구하기
// 인접한 두집 털면 경보 울림

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        int[] dp1 = new int[n];
        // 0번 털면 1번, 마지막 털면 안됨
        dp1[0] = money[0];
        dp1[1] = money[0];

        for (int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        // System.out.println(Arrays.toString(dp1));


        // 0번 안털면
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i=2; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        // System.out.println(Arrays.toString(dp2));


        return Math.max(dp1[n-2], dp2[n-1]);
    }
}