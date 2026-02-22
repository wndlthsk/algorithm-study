// mst -> 프림

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] cost: costs) {
            adjList.get(cost[0]).add(new int[]{cost[1], cost[2]});
            adjList.get(cost[1]).add(new int[]{cost[0], cost[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        boolean[] visited = new boolean[n];

        pq.add(new int[]{0, 0}); // idx, cost

        int total = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            total += now[1];

            for (int[] next: adjList.get(now[0])) {
                if (visited[next[0]]) continue;
                pq.add(new int[]{next[0], next[1]});
            }
        }

        System.out.println(total);
        return total;
    }
}