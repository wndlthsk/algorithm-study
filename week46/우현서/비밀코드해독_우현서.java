// 서로 다른 5개 정수(1~n)의 오름차순 비밀 코드
// q: 입력한 정수 배열
// ans: 시스템 응답 배열 / 몇개 맞췄는지 응답
// 비밀 코드로 가능한 정수 조합 개수 리턴

// 1~n 조합 구해서 조건에 맞는지 검사

import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    int[][] q;
    int[] ans;
    int m;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        m = q.length;

        combination(1, new ArrayList<>());

        return answer;
    }

    int answer = 0;

    public void combination(int start, List<Integer> now) {
        if (now.size() == 5) {
            boolean isCandidate = true;
            for (int i=0; i<m; i++) {
                int count = getCount(q[i], now);
                if (count != ans[i]) {
                    isCandidate = false;
                    break;
                }
            }

            if (isCandidate) answer++;
            return;
        }

        for (int i=start; i<=n; i++) {
            now.add(i);
            combination(i+1, now);
            now.remove(now.size()-1);
        }
    }

    public int getCount(int[] arr, List<Integer> target) {
        int count = 0;
        for (int a: arr) {
            for (int t: target) {
                if (a == t) count++;
            }
        }

        return count;
    }
}