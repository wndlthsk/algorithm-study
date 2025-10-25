import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 가는 길에 만나는 모든 소에게 여물을 줘야함
// n개의 헛간, m개의 양방향 길, c_i 마리의 소
// a, b 헛간을 잇는다.
// 두 헛간은 하나 이상의 길로 연결되어있을 수 있음
// 헛간 1 -> 헛간 n
// 최소 여물 구하기

// 가중치가 다르니까 다익스트라

class Node {
    int to;
    int count;

    public Node(int to, int count) {
        this.to = to;
        this.count = count;
    }
}
public class Main {
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int[] result = dijkstra(n);
//        System.out.println(Arrays.toString(result));
        System.out.println(result[n]);
    }

    public static int[] dijkstra(int n) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.count - b.count);
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        pq.offer(new Node(1, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;
            int count = node.count;

            if (visited[to]) continue;
            visited[to] = true;

            for (Node next: graph.get(to)) {
                int nextTo = next.to;
                int nextCount = next.count;
                if (dist[nextTo] <= dist[to] + nextCount) continue;
                dist[nextTo] = dist[to] + nextCount;
                pq.offer(new Node(nextTo, dist[nextTo]));
            }
        }

        return dist;
    }
}