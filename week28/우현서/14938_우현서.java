import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 각 지역은 길이 l로 다른 지역과 연결되어 있고 양방향 통행 가능
// 낙하 지역 중심으로 거리가 m 이내의 모든 지역의 아이템 습득 가능
// 얻을 수 있는 아이템의 최대 개수 구하기

// 모든 노드에 대해서 다익스트라 돌리면서 각 노드에서 다른 노드까지의 길이 확인하고 (dist[])
// 그게 m보다 적으면 아이템 개수에 추가하고
// 마지막에 최종 답 최댓값으로 갱신

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
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(items));

        List<List<Node>> regions = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            regions.add(new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            regions.get(a).add(new Node(b, c));
            regions.get(b).add(new Node(a, c));
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            Queue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int now = node.to;
                int cost = node.cost;

                for (Node next: regions.get(now)) {
                    int nextTo = next.to;
                    int nextCost = next.cost + cost; // 간선 비용 + 현재까지 비용
                    if (dist[nextTo] > nextCost) {
                        dist[nextTo] = nextCost;
                        pq.add(new Node(nextTo, nextCost));
                    }
                }
            }

//            System.out.println(Arrays.toString(dist));
            int count = 0;
            for (int j=1; j<=n; j++) {
                if (dist[j] <= m) {
                    count += items[j];
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}