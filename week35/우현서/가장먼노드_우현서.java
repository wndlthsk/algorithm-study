// 1~n번 노드
// 1번 노드에서 가장 먼 노드 개수 리턴
// 가장 먼 노드: 최단 경로로 이동했을 때 간선의 개수가 가장 많은 노드들

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e: edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[n+1];
        queue.add(1);
        Arrays.fill(dist, -1);
        dist[1] = 0;

        int max = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: adjList.get(now)) {
                if (dist[next] != -1) continue;

                dist[next] = dist[now] + 1;
                queue.add(next);
                max = Math.max(max, dist[next]);
            }
        }

        int count = 0;
        for (int i=1; i<=n; i++) {
            if (dist[i] == max) count++;
        }

        return count;
    }
}