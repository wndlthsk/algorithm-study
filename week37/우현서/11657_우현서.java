import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// n개 도시, 버스 m개
// a: 시작도시 / b: 도착도시 / c: thdy tlrks
// c=0이면 순간이동 / c<0 타임머신으로 되돌아가는 경우
// 1번 도시에서 출발해 나머지 도시로 가는 가장 빠른 시간 구하기
// 무한히 오래 전으로 되돌릴 수 있으면 -1 출력
// 2~n번 도시로 가는 빠른 시간을 순서대로, 경로 없으면 -1 출력

// 음의 가중치 -> 벨만 포드

class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }


        long[] dist = new long[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i=1; i<n; i++) { // 최대 간선 개수 만큼
            for (Edge e : edges) {
                if (dist[e.from] != Integer.MAX_VALUE && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        for (Edge e: edges) {
            if (dist[e.from] != Integer.MAX_VALUE && dist[e.to] > dist[e.from] + e.cost) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=2; i<dist.length; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i])
                .append("\n");
        }
        System.out.println(sb);
    }
}