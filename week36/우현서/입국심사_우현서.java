// 각 심사관마다 걸리는 시간은 다름
// 처음에 모든 심사대 비어있음
// 한 심사대는 동시에 한명만 심사 가능
// 가장 앞에 있는 사람은 비어있는 심사대 or 빨리 끝나는 심사대
// 모든 사람 심사 시간 최소로
// n: 사람 수
// times: 심사관 걸리는 시간


// 1 60 / mid: 30
// 4 + 3 = 7
// 1 29 / mid: 14
// 2 + 1 = 3
// 15 29 / mid: 23
// 3 + 2 = 5
// 24 29 / mid: 26
// 3 + 2 = 5
// 27 29 / mid : 28
// 4 + 2 = 6

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        long end = 0;
        for (int t: times) {
            end = Math.max(end, t);
        }
        end *= n;
        // System.out.println(start + " " + end);

        long mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            // System.out.println(mid);

            long sum = 0;
            for (int t: times) {
                sum += mid / t;
            }

            // sum == n이더라도 더 적은 시간이 걸릴 수 있으니 계속 갱신해야함
            if (sum >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}