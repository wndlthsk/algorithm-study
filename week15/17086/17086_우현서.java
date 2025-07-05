// nxm 공간, 한칸에 최대 1마리
// 안전 거리: 그 칸과 가장 가까운 상어와 거리
// 두 칸 거리: 지나야하는 칸 수
// 8방향 이동 가능, 안전 거리가 가장 큰 칸 구하기

// 상어 있는 모든 칸에서 bfs 돌려보면서 거리가 젤 큰 값 구하기 x -> 문제 잘못이해함
// 빈칸에서 가장 안전거리가 큰 칸의 안전거리를 구해야함
// 상어 위치 다 큐에 넣고, bfs 돌리면서 상어 만나면 멈춤

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x==1) {
                    queue.add(new int[]{i, j}); // x, y
                    visited[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            for (int d=0; d<8; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == -1) {
                        queue.add(new int[]{nx, ny});
                        int dist = visited[x][y] + 1;
                        visited[nx][ny] = dist;
                        result = Math.max(result, dist);
                    }
                }
            }
        }

//        System.out.println(Arrays.deepToString(visited));
        System.out.println(result);
    }

}