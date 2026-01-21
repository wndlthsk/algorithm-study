// a-b, b-c일때 a,b,c는 같은 네트워크
// 네트워크 개수 리턴


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

        int result = 0;
        boolean[] visited = new boolean[n];
        // bfs
        // for (int i=0; i<n; i++) {
        //     if (visited[i]) continue;
        //     bfs(adjList, visited, i);
        //     result++;
        // }

        // dfs
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            dfs(adjList, visited, i);
            result++;
        }

        return result;
    }

    private void bfs(List<List<Integer>> adjList, boolean[] visited, int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visited[i] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: adjList.get(now)) {
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }
        }
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int i) {
        if(visited[i]) return;
        visited[i] = true;

        for (int next: adjList.get(i)) {
            if (visited[next]) continue;
            dfs(adjList, visited, next);
        }
    }
}