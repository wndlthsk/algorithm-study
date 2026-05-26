// n미터 벽, 왼쪽부터 1~n번
// 롤러 m미터
// 롤러 최소 횟수 리턴


class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;

        int start = section[0];
        int cover = start + m;

        for (int s: section) {
            if (s >= start && s < cover) {
                continue;
            } else {
                start = s;
                cover = start + m;
                answer++;
            }
        }

        return answer;
    }
}