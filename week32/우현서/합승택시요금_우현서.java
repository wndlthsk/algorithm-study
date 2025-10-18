// 합승으로 택시 요금 얼마나 아낄 수 있는지 계산
// 양방향, 예상 요금으로 간선 연결
// 지점 번호 1~n번
// n: 지점 개수
// s: 출발 지점
// a: a의 도착 지점
// b: b의 도착 지점
// fares:지점 사이 요금 [c, d, f]  c-d 사이 요금 f
// 각자 이동하는 게 더싸면 합승 안해도 됨

// s, a, b에서 다익스트라로 모든 노드까지의 요금 구하고, 나머지 노드 돌면서 합이 최소인 거 리턴?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
    int to;
    int fare;

    public Node(int to, int fare) {
        this.to = to;
        this.fare = fare;
    }
}

class Solution {
    List<List<Node>> adjList;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        adjList = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] f: fares) {
            adjList.get(f[0]).add(new Node(f[1], f[2]));
            adjList.get(f[1]).add(new Node(f[0], f[2]));
        }

        int[] fromS = dijkstra(s, n);
        int[] fromA = dijkstra(a, n);
        int[] fromB = dijkstra(b, n);

        // System.out.println(Arrays.toString(fromS));
        // System.out.println(Arrays.toString(fromA));
        // System.out.println(Arrays.toString(fromB));

        int result = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            // (s->i + i->a + i->b) 값이랑 비교해서 갱신
            result = Math.min(result, fromS[i] + fromA[i] + fromB[i]);
        }

        return result;
    }

    public int[] dijkstra(int start, int n) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.fare - b.fare);
        int[] fares = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(fares, Integer.MAX_VALUE);
        fares[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.to;

            if (visited[now]) continue;
            visited[now] = true;

            for (Node next: adjList.get(now)) {
                if (fares[next.to] <= fares[now] + next.fare) continue;
                fares[next.to] = fares[now] + next.fare;
                pq.add(new Node(next.to, fares[next.to]));
            }
        }

        return fares;
    }
}