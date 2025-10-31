import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 사이클 없는 무방향 그래프
// 두 노드 선택시 둘 사이 경로가 항상 하나만 존재함
// 가장 긴 거리의 노드 두개 선택하면, 이 두 노드를 지름의 끝점으로 하는 원 안에 들어감
// 이 거리를 트리의 지름
// 트리의 지름: 트리에 존재하는 모든 경로들 중 가장 긴 것의 길이
// 가중치 있는 간선들,
// 트리의 지름 구하기

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
    static List<List<Node>> tree;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(a).add(new Node(b, c));
            tree.get(b).add(new Node(a, c));
        }
//        System.out.println(tree);

        int[] temp = dijkstra(1);
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (max < temp[i]) {
                max = temp[i];
                maxIndex = i;
            }
        }
        int[] result = dijkstra(maxIndex);
        int maxResult = Arrays.stream(result).max().getAsInt();

        System.out.println(maxResult);
    }

    public static int[] dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> b.weight - a.weight);
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowTo = now.to;
            int nowWeight = now.weight;
            if (visited[nowTo]) continue;
            visited[nowTo] = true;

            for (Node next: tree.get(nowTo)) {
                int nextTo = next.to;
                int nextWeight = next.weight;

                if (visited[nextTo]) continue;

                if (dist[nextTo] >= dist[nowTo] + nextWeight) continue;
                dist[nextTo] = dist[nowTo] + nextWeight;
                pq.offer(new Node(nextTo, dist[nextTo]));
            }

        }

        return dist;
    }

}