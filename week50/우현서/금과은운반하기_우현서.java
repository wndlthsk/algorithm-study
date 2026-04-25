// 도시에 금 a, 은 b 키로가 전달돼야함
// 새로운 도시 건설에 가장 빠른 시간 구하기
// g: 금 / s: 은 / 트럭 한대 / t: 편도 이동 시간 / w: 최대 운반 광물

// 특정 시간안에 가능한지 판별, 이분탐색

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;

        int n = t.length;

        long left = 0;
        long right = (long) 1e15;

        while (left <= right) {
            long mid = (left + right) / 2;

            // 금만/ 은만 / 둘다 옮겼을 때 누적량
            long gold = 0;
            long silver = 0;
            long total = 0;

            for (int i=0; i<n; i++) {
                long move = mid / (2 * t[i]); // 왕복으로 이동 가능한 횟수
                if (mid % (t[i] * 2 * move) >= t[i]) move++; // 편도로 갈 수 있는지 확인

                long possible = move * w[i]; // 총 옮길 수 있는 무게

                gold += Math.min(g[i], possible);
                silver += Math.min(s[i], possible);
                total += Math.min(g[i]+s[i], possible);
            }

            if (gold >= a && silver >= b && total >= a+b) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}