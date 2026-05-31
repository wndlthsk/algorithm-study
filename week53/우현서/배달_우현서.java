// 각 마을은 1~N번
// 양방향 통행 도로, 도로별 소요 시간
// 1번마을에서 k시간 이하로 배달 가능한 마을 개수

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    List<List<int[]>> adjList;
    int N;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        this.N = N;

        adjList = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] r: road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            adjList.get(a).add(new int[]{b, c});
            adjList.get(b).add(new int[]{a, c});
        }
        int[] result = dijkstra(1);
        // System.out.println(Arrays.toString(result));

        for (int i=1; i<=N; i++) {
            if (result[i] <= K) answer++;
        }

        return answer;
    }

    private int[] dijkstra(int start) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // 마을 번호, 거리
        queue.add(new int[]{start, 0});
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = now[0];
            int d = now[1];

            if (visited[num]) continue;
            visited[num] = true;

            for (int[] next: adjList.get(num)) {
                int nextNum = next[0];
                int nextDist = next[1];

                if (visited[nextNum]) continue;
                if (dist[nextNum] <= d + nextDist) continue;

                dist[nextNum] = d + nextDist;
                queue.add(new int[]{nextNum, dist[nextNum]});
            }
        }

        return dist;
    }
}