// n명 입국 심사,
// 모든 사람 심사에 걸리는 최소 시간

// t분 안에 총 몇 명 심사 가능한가

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int max = 0;
        for (int t: times) {
            max = Math.max(max, t);
        }
        long left = 1;
        long right = (long) n * max;

        while (left <= right) {
            long mid = (right + left)/2;
            long people = 0;
            for (int t: times) {
                people += mid / t;
            }

            if (people >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }



        return answer;
    }
}