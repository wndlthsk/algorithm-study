package week36.우현서;// 각 지역은 번호로 구분, 두 지역 간 걸리는 시간은 모두 1
// 각 부대원은 최단시간에 부대 복귀
// 되돌아오는 경로가 없어져 불가능할 수도
// n: 총 지역의 수
// roads: 두지역 왕복하는 길 정보, [a, b]
// destination: 부대 지역
// sources: 원소 순서대로 부대 복귀할 수 있는 최단 시간을 리턴
// 불가능한 부대원은 -1

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    List<List<Integer>> adjList;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        adjList = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] r: roads) {
            adjList.get(r[0]).add(r[1]);
            adjList.get(r[1]).add(r[0]);
        }
        // System.out.println(adjList);

        int[] temp = bfs(n, destination);
        List<Integer> result = new ArrayList<>();
        for (int s: sources) {
            result.add(temp[s]);
        }

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public int[] bfs(int n, int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] visited = new int[n+1];
        queue.add(new int[]{start, 0});
        Arrays.fill(visited, -1);
        visited[start] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int count = now[1];

            for (int next: adjList.get(x)) {
                if (visited[next] != -1) continue;
                visited[next] = count + 1;
                queue.add(new int[]{next, visited[next]});
            }
        }

        return visited;
    }
}