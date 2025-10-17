import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 방향그래프, 시작점에서 다른 모든 정점으로의 최단 경리 구하기
// 정점은 1~N

// 다익스트라 구현

class Node {
    int to;
    int weight;
    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public String toString() {
        return "(" + to + "," + weight + ")";
    }
}

public class Main {
    static int V;
    static int E;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()); // 시작 정점

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }
//        System.out.println(graph);

        int[] result = dijkstra(K);
        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }

    }

    public static int[] dijkstra(int start) {
        int[] distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        distance[start] = 0;
//        visited[start] = true; // 시작점을 true로 두면 안됨. 여기랑 연결된 노드로 확장 못하기때문
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.to;

            if (visited[now]) continue;
            visited[now] = true;

            for (Node n: graph.get(now)) {
                if (distance[n.to] <= distance[now] + n.weight) continue;
                distance[n.to] = distance[now] + n.weight;
                pq.add(new Node(n.to, distance[n.to]));
            }

        }
//        System.out.println(Arrays.toString(distance));
        return distance;

    }
}