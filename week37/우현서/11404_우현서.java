import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// n개 도시, 버스 m개
// 각 버스는 비용
// 모든 도시 이동하는 비용 최솟값 구하기
//
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE/2);
            dist[i][i] = 0;
        }
        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE/2) {
                    sb.append(0 + " ");
                } else {
                    sb.append(dist[i][j]  + " ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);


        // 다익스트라
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//
//        List<List<Node>> adjList = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            adjList.add(new ArrayList<>());
//        }
//
//        StringTokenizer st;
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            adjList.get(a).add(new Node(b, c));
//        }
//        result = new int[n+1][n+1];
////        System.out.println(adjList);
//
//        for (int i = 1; i <= n; i++) {
//            dijkstra(i, adjList);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=n; j++) {
//                if (result[i][j] == Integer.MAX_VALUE/2) {
//                    sb.append(0 + " ");
//                } else {
//                    sb.append(result[i][j]  + " ");
//                }
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);

    }

    static int[][] result;

    public static void dijkstra(int start, List<List<Node>> adjList) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] costs = new int[adjList.size()];
        boolean[] visited = new boolean[adjList.size()];
        Arrays.fill(costs, Integer.MAX_VALUE/2);
        costs[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.to]) continue;
            visited[curr.to] = true;

            for (Node neighbor : adjList.get(curr.to)) {
                if (visited[neighbor.to]) continue;
                if (costs[neighbor.to] <= curr.cost + neighbor.cost) continue;

                costs[neighbor.to] = curr.cost + neighbor.cost;
                pq.offer(new Node(neighbor.to, costs[neighbor.to]));
            }
        }

        result[start] = Arrays.copyOf(costs, costs.length);
    }
}