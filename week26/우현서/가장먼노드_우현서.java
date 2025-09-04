// 노드 n개 그래프, 1~n번 (1-based)
// 1번에서 가장 멀리 떨어진 노드의 개수 리턴
// 가장 멀리 떨어짐: 최단 경로로 이동시 간선의 개수가 가방 많은 노드

// 모든 노드 최단 경로로 이동, max값 갱신, 같으면 카운트
// 최단 경로는 bfs

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    List<List<Integer>> adjList;

    public int solution(int n, int[][] edge) {
        // 인접리스트 변환
        adjList = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e: edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        // bfs 돌려서 visited에 1에서 각 노드까지의 최단 거리를 저장
        Queue<int[]> queue = new ArrayDeque<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);

        queue.add(new int[]{1, 0}); // 1에서 시작은 고정
        visited[1] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int cnt = now[1];

            for (int next: adjList.get(x)) {
                if (visited[next] == -1) {
                    queue.add(new int[]{next, cnt+1});
                    visited[next] = visited[x] + 1;
                }
            }
        }

        int max = 0;
        int count = 0;

        for (int x : visited) {
            if (x > max) {
                max = x;
                count = 1;
            } else if (x == max) {
                count++;
            }
        }

        return count;
    }
}