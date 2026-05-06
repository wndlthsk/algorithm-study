// 1~n번, n-1개의 파이프로 이어서 하나의 트리 모양
// 감염된 배양체는 열린 파이프로 다른 인접 배양체를 감염시킴
// 같은 종류 파이프는 한번에 모두 열었다 닫을 수 있음, 닫기 전에 다른 종류 열수 없음
// 열고 닫기 최대 k번 반복해서 최대로 감염, 감염된 최대 개수 리턴
// edges[i] : [노드x, 노드y, 파이프type]

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {
    int y;
    int type;

    public Node (int y, int type) {
        this.y = y;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + "y: " + y + " type: " + type + "]";
    }
}

class Solution {
    List<List<Node>> adjList;
    int k;
    int n;
    int maxType;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.n = n;
        this.k = k;

        adjList = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e: edges) {
            int x = e[0];
            int y = e[1];
            int type = e[2];
            adjList.get(x).add(new Node(y, type));
            adjList.get(y).add(new Node(x, type));
            maxType = Math.max(maxType, type);
        }


        boolean[] infected = new boolean[n+1];
        infected[infection] = true;


        dfs(infected, 0);


        return max;
    }

    int max = 0;

    public void dfs(boolean[] infected, int depth) {
        if (depth == k) {
            int count = 0;
            for (boolean b: infected) {
                if (b) count++;
            }

            max = Math.max(max, count);

            return;
        }

        for (int type=1; type<=maxType; type++) {
            boolean[] next = bfs(infected, type);
            dfs(next, depth+1);
        }
    }

    public boolean[] bfs(boolean[] infected, int type) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            if (infected[i]) {
                visited[i] = true;
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (Node next: adjList.get(now)) {
                if (next.type != type) continue;
                if (visited[next.y]) continue;

                queue.add(next.y);
                visited[next.y] = true;
            }
        }

        return visited;
    }
}