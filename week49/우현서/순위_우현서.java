// 1ㄷ1, 실력 좋은선수가 항상 이김
// 정확히 순위 매길 수 있는 선수의 수 리턴

// 이긴거, 진거 따로 구해서 개수확인?

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }

        for (int[] r: results) {
            win.get(r[0]).add(r[1]);
            lose.get(r[1]).add(r[0]);
        }

        for (int i=1; i<=n; i++) {
            int cnt1 = bfs(win, i, n);
            int cnt2 = bfs(lose, i, n);

            if(cnt1 + cnt2 == n-1) answer++;
        }


        return answer;
    }

    private int bfs(List<List<Integer>> graph, int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        queue.add(start);
        visited[start] = true;
        int total = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: graph.get(now)) {
                if (visited[next]) continue;

                queue.offer(next);
                visited[next] = true;
                total++;
            }
        }

        return total;
    }
}