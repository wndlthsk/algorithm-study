// n명씩 두팀
// 모든 사원 무작위 자연수
// 한번씩 경기
// 한명씩 자기 수 공개, 숫자 큰쪽이 승리, 그 팀이 +1점
// 같으면 승점 x
// A팀의 순서를 보고 B팀의 최대 승점 구하기

// 정렬 -> 무조건 되진 않는다
// 둘다 정렬, 포인터 관리를 해서 가장 작은 차이로 이기게 하자
// 정렬 O(n log n) + 투포인터 O(n) -> O(n log n)

// 백트래킹으로? 모든 순열?
// 1 <= n <= 100000 --> O(n!) 순열 불가

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int p1 = 0;
        int p2 = 0;
        int score = 0;
        while (p1 < n && p2 < n) {
            if (A[p1] < B[p2]) {
                score++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }

        return score;
    }

}