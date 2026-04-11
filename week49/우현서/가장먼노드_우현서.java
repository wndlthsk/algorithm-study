// 1~n 노드,
// 1번 노드에서 가장 멀리 떨어진 노드 갯수 구하기

// bfs


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e: edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        // System.out.println(adjList);

        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        dist[1] = 0;
        queue.offer(1);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: adjList.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        int max = 0;
        for (int x: dist) {
            max = Math.max(max, x);
        }

        int answer = 0;
        for (int x: dist) {
            if (x == max) answer++;
        }

        return answer;
    }
}