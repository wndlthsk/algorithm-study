import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 모든 정점 연결하는 부분 그래프 중 가중치 합이 최소인 트리

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node [to=" + to + ", cost=" + cost + "]";
    }
}

public class Main {
    static List<List<Node>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        adjList = new ArrayList<>();
        for (int i=0; i<=v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new Node(b, c));
            adjList.get(b).add(new Node(a, c));
        }

        int result = prim(v);
        System.out.println(result);
    }

    public static int prim(int v) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[v+1];
        pq.offer(new Node(1, 0));
        int total = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.to]) continue;
            visited[now.to] = true;
            total += now.cost;

            for (Node next: adjList.get(now.to)) {
                if (!visited[next.to]) pq.offer(next);
            }
        }

        return total;
    }
}