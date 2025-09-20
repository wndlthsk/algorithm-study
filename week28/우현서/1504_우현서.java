import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 무방향 그래프
// 1번 -> n번 최단 거리 이동
// 임의의 두 정점은 반드시 통과해야함
// 정점, 감선 모두 다시 이동 가능
// 최단 경로 길이 구하기
// 경로 없으면 -1

// min(1->v1 + v2->n, 1->v2 + v1->n) + v1->v2
// 가중치 있고 최단 경로니까 다익스트라 3번 돌린다. (1, v1, v2)

class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return "Node [to=" + to + ", cost=" + cost + "]";
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] from1 = dijkstra(1, graph, n);
        int[] fromv1 = dijkstra(v1, graph, n);
        int[] fromv2 = dijkstra(v2, graph, n);

        // min(1->v1 + v2->n, 1->v2 + v1->n) + v1->v2
        if (from1[v1] == Integer.MAX_VALUE || fromv2[n] == Integer.MAX_VALUE ||
            from1[v2] == Integer.MAX_VALUE || fromv1[n] == Integer.MAX_VALUE ||
            fromv1[v2] == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }
        int result = Math.min(from1[v1]+fromv2[n], from1[v2]+fromv1[n]) + fromv1[v2];
        System.out.println(result);
    }

    public static int[] dijkstra(int start, List<List<Node>> graph, int n) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.to;
            int cost = node.cost;

            for (Node next : graph.get(now)) {
                int nextTo = next.to;
                int nextCost = next.cost + cost; // 간선 비용 + 현재까지 비용
                if (dist[nextTo] > nextCost) {
                    dist[nextTo] = nextCost;
                    pq.add(new Node(nextTo, nextCost));
                }
            }
        }

        return dist;
    }
}