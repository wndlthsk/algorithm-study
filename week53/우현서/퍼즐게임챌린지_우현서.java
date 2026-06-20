// diff <= level : time += time_cur
// diff > level : time += (time_cur+time_prev) * (diff-level) + time_cur
// limit안에 해결하기 위한 숙련도의 최솟값 구하기

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int l = 1;
        int r = 0;
        for (int d: diffs) {
            r = Math.max(r, d);
        }

        int answer = 0;
        while (l <= r) {
            int mid = (l+r)/2;
            long time = 0;

            for (int i=0; i<n; i++) {
                if (diffs[i] <= mid) {
                    time += times[i];
                } else {
                    int prev = (i==0) ? 0 : i-1;
                    time += (times[i] + times[prev]) * (diffs[i]-mid) + times[i];
                }

                if (time > limit) break;
            }

            if (time <= limit) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }


        return answer;
    }
}