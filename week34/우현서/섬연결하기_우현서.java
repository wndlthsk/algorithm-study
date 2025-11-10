// costs: n개의 섬 사이 다리 건설 비용
// [섬1, 섬2, 비용] / 양방향
// 최소 비용으로 모든 섬 통행 가능하게 하는 최소 비용 구하기

// 최소신장트리 ???

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Node {
    int to;
    int cost;

    public Node (int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    public String toString() {
        return "(to: " + to + " cost: " + cost + ")";
    }
}

class Solution {
    List<List<Node>> adjList;

    public int solution(int n, int[][] costs) {
        adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] c: costs) {
            adjList.get(c[0]).add(new Node(c[1], c[2]));
            adjList.get(c[1]).add(new Node(c[0], c[2]));
        }

        // System.out.println(adjList);
        int answer = prim(n, 0);

        return answer;
    }

    public int prim(int n, int start) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n];
        pq.add(new Node(start, 0));
        int total = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.to]) continue;
            visited[now.to] = true;
            total += now.cost;

            for (Node next: adjList.get(now.to)) {
                if (!visited[next.to]) pq.add(next);
            }
        }

        return total;
    }
}