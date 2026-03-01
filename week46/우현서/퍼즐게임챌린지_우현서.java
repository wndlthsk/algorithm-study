// n개 퍼즐, 난이도/소요 시간
// 숙련도에 따라 틀리는 횟수가 바뀜
// 현재 퍼즐 난이도 <= 숙련도 : 틀리지 않고 현재 퍼즐 소요시간 사용
// 아니면 : 퍼즐을 (난이도 - 숙련도)번 틀림, 틀릴때마다 현재 퍼즐 소요시간만큼 사용, 이전 퍼즐 소요시간만큼 사용해 이전퍼즐을 다시 풀어야함
// 제한 시간 내에 퍼즐을 모두 해결하는 숙련도의 최솟값 구하기

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;

        int l = 1;
        int r = 0;
        for (int d: diffs) {
            r = Math.max(r, d);
        }

        int answer = r;
        while(l <= r) {

            int mid = (l+r)/2;
            long time = 0;

            for (int i=0; i<n; i++) {
                if (mid >= diffs[i]) time += times[i];
                else {
                    int repeat = diffs[i]-mid;
                    int prev = (i == 0) ? 0 : times[i - 1];
                    time += times[i] + times[i]*repeat + prev*repeat;
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