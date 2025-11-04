// 삼각형 꼭대기에서 바닥까지 경로 중 숫자합이 가장 큰 경우 찾기
// 아래 이동시 대각선 오/왼 한칸만 가능
// 최댓값 리턴

// 각 칸에서 위에서 올수 있는 거 중 합이 최대인거 저장해나가기

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        for (int i=1; i<n; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                int left = 0;
                int right = 0;
                if (j-1 >= 0) left = triangle[i-1][j-1];
                if (j+1 < triangle[i].length) right = triangle[i-1][j];
                triangle[i][j] += Math.max(left, right);
            }
        }

        for (int i=0; i<n; i++) {
            answer = Math.max(answer, triangle[n-1][i]);
        }

        return answer;
    }
}