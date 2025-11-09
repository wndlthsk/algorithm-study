// 2*n명 사원을 n명씩 두팀
// 모든 사원 무작위 자연수 부여받음
// 각 사원은 한번씩 경기
// 각 경기당 a팀에서 한명, b팀에서 한명이 서로 수 공개, 숫자 크면 승리, 승점 1점
// 숫자 같으면 승점 x
// a팀 출전 순서를 알때, b팀이 최종 승점 높이는 방법으로 순서 정함
// b팀이 얻는 승점 구하기
// A: a팀의 출전 순서대로 숫자 배열
// B: b팀의 i번 팀원의 수

// b팀 숫자를 순열 구해서 점수 갱신? -> n이 100,000이면 100,000!이라 안됨
// 둘다 오름차순, 하나씩 비교, b가 이기면 둘다 포인터 올리고
// b가 지면 b만 올린다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
class Solution {
    public int solution(int[] A, int[] B) {
        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0;
        int b = 0;
        int count = 0;

        while(a < n && b < n) {
            if (A[a] < B[b]) {
                count++;
                a++;
                b++;
            } else {
                b++;
            }
        }

        return count;
    }

    // 순열 구현
    // (중복 순열은 visited 안씀)
    List<Integer> output;
    boolean[] visited;
    Set<List<Integer>> candidates;

    public void permutation(int[] B, int depth, int n, int r) {
        if(depth == r) {
            candidates.add(new ArrayList<>(output));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output.add(B[i]);
                permutation(B, depth + 1, n, r);
                output.remove(output.size()-1);
                visited[i] = false;
            }
        }
    }
}