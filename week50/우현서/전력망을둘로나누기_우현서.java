// 트리에서 간선 끊어서 각 전력망의 송전탑 개수를 최대한 비슷하게
// 간선 끊으면 끊긴 노드를 루트로 각각 서브트리 생김. 각 서브트리의 노드 수 차이
// 노드 수는 bfs로 카운트 할 수 있음

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    List<List<Integer>> adjList;
    public int solution(int n, int[][] wires) {

        adjList = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] w: wires) {
            adjList.get(w[0]).add(w[1]);
            adjList.get(w[1]).add(w[0]);
        }

        int answer = Integer.MAX_VALUE;
        subtree = new int[n+1];

        dfs(1, 0);
        // System.out.println(Arrays.toString(subtree));
        for (int[] w: wires) {
            int less = Math.min(subtree[w[0]], subtree[w[1]]); // 더 많은쪽 서브트리에 적은게 속함 => 자르면 더 큰쪽의 노드 수는 n-less가 된다.
            answer = Math.min(answer, Math.abs((n-less) - less));
        }


        // for (int[] w: wires) {
        //     boolean[] visited = new boolean[n+1];
        //     visited[w[0]] = true;
        //     visited[w[1]] = true;
        //     int count1 = bfs(w[0], visited);
        //     int count2 = n - count1;
        //     answer = Math.min(answer, Math.abs(count1-count2));
        // }

        return answer;
    }

    private int bfs(int start, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        int count = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            for (int next: adjList.get(now)) {
                if (visited[next]) continue;

                count++;
                q.add(next);
                visited[next] = true;
            }
        }

        return count;
    }

    int[] subtree;
    private int dfs(int now, int parent) { // now를 루트로 하는 서브트리의 노드 수
        subtree[now] = 1;


        for (int next: adjList.get(now)) {
            if (next == parent) continue;
            subtree[now] += dfs(next, now);
        }

        return subtree[now];
    }
}