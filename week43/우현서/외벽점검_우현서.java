// 외벽 둘레 n미터
// 점검시간 1시간, 친구마다 이동 거리 다름
// 북 방향 지점을 0, 취약지점 위치는 북 방향으로부터 시계방향으로 떨어진 거리
// 출발지점에서 시계 or 반시계로 외벽 이동
// 취약 지점을 점검하기 위해 필요한 친구의 최솟값 구하기
// n: 외벽 길이
// weak: 취약 지점 우치ㅣ
// dist: 각 친구가 1시간 동안 이동 가능한 거리


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int wLen = weak.length;
        // 취약 지점 2배 늘리기
        int[] newWeak = new int[2 * wLen];
        for (int i=0; i<wLen; i++) {
            newWeak[i] = weak[i];
            newWeak[i+wLen] = weak[i] + n;
        }

        // 순열 구해서 그 친구 수로 커버 가능한지 판단
        for (int i=1; i<= dist.length; i++) {
            visited = new boolean[dist.length];
            candidates = new ArrayList<>();
            permutation(0, dist.length, i, new ArrayList<>());
            // System.out.println(candidates);

            for (List<Integer> can: candidates) {
                // 현재 친구로 커버 가능한지
                for (int start = 0; start < wLen; start++) {
                    int idx = start; // 현재 처리할 취약지점의 인덱스

                    for (int c: can) {
                        int coverEnd = newWeak[idx] + dist[c];
                        while (newWeak[idx] <= coverEnd) {
                            idx++;

                            if (idx >= start + wLen) return i;
                        }
                    }
                }
            }
        }

        return -1;
    }


    boolean[] visited;
    List<List<Integer>> candidates;

    public void permutation(int depth, int n, int r, List<Integer> result) {
        if (depth == r) {
            candidates.add(new ArrayList<>(result));
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(i);
                permutation(depth+1, n, r, result);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }

}