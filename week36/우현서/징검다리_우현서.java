// 출발지 -distance - 도착지
// 이 사이에 바위있음, 바위 몇개 제거할지
// 2 11 14
// 2, 9, 3, 11
// rocks: 바위 위치 배열
// n: 제거할 바위 수
// 최소 거리의 최댓값을 구해야함

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int start = 0;
        int end = distance;
        int mid = 0; // 거리 최솟값을 mid로 만들수 있나를 검증해야함
        // 어떻게 검증? 그리디
        // mid 이상의 최소 거리 유지를 위해 몇개를 제거해야하는지 확인
        while (start <= end) {
            mid = (start + end) / 2;

            int count = 0;
            int before = 0;
            for (int r: rocks) {
                if (r - before < mid) { // 제거해야할 돌
                    count++;
                }
                else { // 제거 안하면 before 갱신
                    before = r;
                }

                if (count > n) break;
            }

            // 마지막 구간
            if (distance - before < mid) count++;


            if (count > n) { // 제거해야할 돌이 n개 초과 -> 불가능 -> 거리를 줄인다
                end = mid -1;
            } else { // 제거해야할 돌이 n이하 -> 가능 -> 거리를 최대화
                answer = mid;
                start = mid + 1;
            }

        }

        return answer;
    }
}