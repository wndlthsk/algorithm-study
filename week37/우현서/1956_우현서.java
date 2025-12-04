import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// v 마을 1번~v번, e 도로 일방통행
// 사이클 이루는 도로의 길이 최소 합
// 경로 불가능한 경우 -1 출력

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] dist = new int[v+1][v+1];

        for (int i=0; i<=v; i++) {
            Arrays.fill(dist[i], INF);
//            dist[i][i] = 0;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for (int k=1; k<=v; k++) {
            for (int i=1; i<=v; i++) {
                for (int j=1; j<=v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (dist[i][j] != INF && dist[j][i] != INF) {
                    result = Math.min(result, dist[i][j] + dist[j][i]);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
}