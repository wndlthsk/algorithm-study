// n개 퍼즐
// 숙련도에 따라 퍼즐 풀때 틀리는 횟수가 바뀜
// 난이도 <= 숙련도
// 시간 += time_cur
// 난이도 > 숙련도
// 틀린 횟수 += 난이도 - 숙련도, 틀릴때마다 시간 += time_cur + time_prev, 마지막 맞출때 += time_cur
// 제한시간 limit내에 모두 해결하기 위한 숙련도의 최솟값 구하기

// 이분탐색

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int l = 1;
        int r = 0;
        for (int d: diffs) {
            r = Math.max(r, d);
        }

        int answer = 0;

        while (l <= r) {
            int level = (l+r)/2;

            long total = 0;
            for (int i=0; i<times.length; i++) {
                if (diffs[i] <= level) {
                    total += times[i];
                } else {
                    int cnt = diffs[i] - level;
                    int prev = (i == 0) ? 0 : times[i-1];
                    total += (times[i] + prev) * cnt + times[i];
                }

                if (total > limit) break;
            }

            if (total > limit) l = level + 1;
            else {
                r = level - 1;
                answer = level;
            }
        }

        return answer;
    }
}