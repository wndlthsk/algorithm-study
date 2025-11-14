// n개의 스티커가 원형으로 연결
// 몇개 뜯어낸 숫자의 합이 최대가 되게
// 한장 뜯으면 양쪽 스티커는 사용할 수 없음
// 숫자합의 최댓값 리턴
// sticker: 숫자 배열 , 길이 100,000 이하

// 백트래킹 하면서 갱신? 시간 얼마나 걸릴까 -> 시간 초과, 방문배열 처리가 애매함
// dp[i] : i번째까지 최댓값
// dp[i] = max(dp[i-1], dp[i-2]+ sticker[i])

class Solution {

    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;

        if (n == 1) return sticker[0];
        if (n == 2) return Math.max(sticker[0], sticker[1]);

        // 첫 원소 선택한 경우
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(dp1[0], sticker[1]);
        for(int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        // 첫 원소 선택 안한 경우
        int[] dp2 = new int[n];
        dp2[1] = sticker[1];
        dp2[2] = Math.max(dp2[1], sticker[2]);
        for (int i=3; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        answer = Math.max(dp1[n-2], dp2[n-1]);

        return answer;
    }
}