// ab, bc일때 a,b,c는 같은 네트워크
// 네트워크 개수 구하기

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                if (computers[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            bfs(adjList, visited, i);
            answer++;
        }

        return answer;
    }

    public void bfs(List<List<Integer>> adjList, boolean[] visited, int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(idx);
        visited[idx] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: adjList.get(now)) {
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }
        }
    }
}