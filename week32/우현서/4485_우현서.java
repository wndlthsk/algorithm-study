import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 화폐단위 루피
// 도둑루피 - 검정 루피 -> 소지한 루피 감소
// 도둑루피만 있는 nxn 동굴의 0,0에 위치
// n-1, n-1로 이동해야함
// 잃는 금액을 최소로 해서 이동, 한번에 4방향 1칸씩 이동가능
// 잃는 최소 금액 구하기
// 출력) Problem 1: 20

// bfs는 안된다. 가중치가 다르기때문 -> 다익스트라 필요

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int t = 0;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            t++;

            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            System.out.println(Arrays.deepToString(cave));

            int[][] dij = dijkstra(n, cave, 0, 0);
//            System.out.println(Arrays.deepToString(dij));
            System.out.println("Problem " + t + ": " + dij[n-1][n-1]);
        }


    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int[][] dijkstra(int n, int[][] cave, int startX, int startY) {
        int[][] distance = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        distance[startX][startY] = cave[startX][startY];
        pq.add(new int[]{startX, startY, cave[startX][startY]});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (distance[nx][ny] <= distance[x][y] + cave[nx][ny]) continue;
                distance[nx][ny] = distance[x][y] + cave[nx][ny];
                pq.add(new int[]{nx, ny, distance[nx][ny]});
            }
        }

        return distance;
    }

}