// n개 섬, 모든 섬 통행가능하게 만드는 최소 비용 구하기
// costs : [섬1, 섬2, 비용]

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] costs) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] cost: costs) {
            adjList.get(cost[0]).add(new int[]{cost[1], cost[2]});
            adjList.get(cost[1]).add(new int[]{cost[0], cost[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];

        pq.add(new int[]{0, 0});

        int result = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            result += now[1];

            for (int[] next: adjList.get(now[0])) {
                if (visited[next[0]]) continue;
                pq.add(next);
            }
        }

        return result;
    }
}