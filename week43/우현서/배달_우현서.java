// 각 마을은 1~N번
// 양방향 통행 도로, 도로별 소요 시간
// k시간 이하로 배달 가능한 마을 개수

// pq쓸때도 Integer.compare 쓰자
// new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

// 다익스트라에서 visited 대신 아래를 추가할 수 있다 근데 걍 visited쓸래
// if (now[1] > dist[now[0]]) continue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] r: road) {
            adjList.get(r[0]).add(new int[]{r[1], r[2]});
            adjList.get(r[1]).add(new int[]{r[0], r[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        pq.add(new int[]{1, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if (visited[now[0]]) continue;
            visited[now[0]] = true;

            for (int[] next: adjList.get(now[0])) {
                if (dist[next[0]] <= now[1] + next[1]) continue;
                dist[next[0]] = now[1] + next[1];
                pq.add(new int[]{next[0], dist[next[0]]});
            }
        }

        int result = 0;
        for (int d: dist) {
            if (d <= K) result++;
        }

        return result;
    }
}