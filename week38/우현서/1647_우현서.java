import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// n개 집, m개 길, 길마다 유지비
// 마을 분리시 각 분리된 마을 안에 집들이 서로 연결돼야함
// 필요없는 길 모두 없애고 나머지 길의 유지비의 합을 최소로 유지
// 합의 최솟값 구하기

// mst로 합 구하고 그중 젤 큰 거 끊기

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Node(b, c));
            adjList.get(b).add(new Node(a, c));
        }

        int result = prim(n);
        System.out.println(result - max);

    }

    static int max = 0;

    public static int prim(int n) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n+1];
        pq.offer(new Node(1, 0));
        int total = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.to]) continue;
            visited[now.to] = true;
            total += now.cost;
            max = Math.max(max, now.cost);

            for (Node next: adjList.get(now.to)) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        return total;
    }

}