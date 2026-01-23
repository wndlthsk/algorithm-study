// n개 송전탑이 트리 형태
// 전선중 하나를 끊어서 네트워크 2개로 분할
// 송전탑 개수를 최대한 비슷하게

// adjList 만들고 wires에서 하나씩 지워보면서 하나의 네트워크에 몇갠지 bfs로 카운트
// bfs로 하면 n만큼 bfs를 돌아야한다 -> O(n^2)
// dfs로 각 노드의 서브트리의 개수를 구해두면 한번만 돌려도 됨 -> O(n)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] wire: wires) {
            adjList.get(wire[0]).add(wire[1]);
            adjList.get(wire[1]).add(wire[0]);
        }

        // bfs
//         int min = Integer.MAX_VALUE;

//         for (int i=0; i<wires.length; i++) {
//             int[] wire = wires[i];
//             adjList.get(wire[0]).remove(Integer.valueOf(wire[1]));
//             adjList.get(wire[1]).remove(Integer.valueOf(wire[0]));

//             int count = bfs(adjList, n, 1);
//             int diff = Math.abs(n - count - count);
//             min = Math.min(min, diff);

//             adjList.get(wire[0]).add(wire[1]);
//             adjList.get(wire[1]).add(wire[0]);
//         }

        // dfs
        counts = new int[n+1];
        dfs(adjList, n, 1, -1);
        int min = Integer.MAX_VALUE;
        for (int[] w: wires) {
            int subTree = Math.min(counts[w[0]], counts[w[1]]);
            int diff = Math.abs(n - subTree - subTree);
            min = Math.min(min, diff);
        }


        return min;
    }



    private int bfs(List<List<Integer>> adjList, int n, int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        queue.add(i);
        visited[i] = true;

        int count = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int next: adjList.get(now)) {
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
                count++;
            }
        }

        return count;
    }



    int[] counts;

    private int dfs(List<List<Integer>> adjList, int n, int now, int parent) {
        int count = 1;
        for (int next: adjList.get(now)) {
            if (next == parent) continue;
            count += dfs(adjList, n, next, now);
        }

        counts[now] = count;
        return count;
    }
}