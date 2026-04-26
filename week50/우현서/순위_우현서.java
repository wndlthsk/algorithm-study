// 순위 매길 수 있는 선수 수 구하기

// 이기고 진 간선 각각 구해서 합이 전체 명수랑 같으면 알 수 있음

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> lose = new ArrayList<>();
        List<List<Integer>> win = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            lose.add(new ArrayList<>());
            win.add(new ArrayList<>());
        }

        for (int[] r: results) {
            int winner = r[0];
            int loser = r[1];

            lose.get(loser).add(winner);
            win.get(winner).add(loser);
        }


        for (int i=1; i<=n; i++) {
            int winCount = bfs(n, i, win);
            int loseCount = bfs(n, i, lose);

            if (winCount + loseCount == n-1) {
                // System.out.println(i);
                answer++;
            }
        }


        return answer;
    }

    private int bfs(int n, int start, List<List<Integer>> adjList) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: adjList.get(now)) {
                if (visited[next]) continue;

                queue.add(next);
                visited[next] = true;
                count++;
            }
        }

        return count;
    }
}