// 1번에서 가장 먼 노드 개수 구하기
// 최단 경로 이동했을 때 간선 개수가 많은 노드들

// 다익스트라. 1번에서 모든 노드 거리 구하기
// 아니다. 가중치 없으니 bfs로 가능
// 근데 모든 노드 for문 안돌리고 dp같이 누적할 수 있을 듯

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

    List<List<Integer>> adjList;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        adjList = new ArrayList<>();
        for (int i=0; i<=n ;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e: edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }


        int[] result = bfs(1, n);
        // System.out.println(Arrays.toString(result));

        int count = 0;
        for (int x: result) {
            if (x == max) count++;
        }


        return count;
    }

    int max = 0;

    private int[] bfs(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: adjList.get(now)) {
                if (dist[next] != -1) continue;

                dist[next] = dist[now] + 1;
                max = Math.max(max, dist[next]);
                queue.add(next);
            }
        }

        return dist;
    }
}