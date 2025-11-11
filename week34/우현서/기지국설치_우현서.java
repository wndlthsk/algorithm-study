// n개 아파트 일렬
// stations: 현재 기지국이 설치된 아파트 번호
// w: 전파 도달 거리
// 모든 아파트에 전파 전달하기 위해 증설해야할 기지국 최소 개수 구하기


class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            if (start < left) {
                int gap = left - start;
                answer += (gap + coverage - 1) / coverage;
            }

            start = right + 1;
        }

        // 마지막 기지국 이후에 남은 구간 처리
        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;
    }
}