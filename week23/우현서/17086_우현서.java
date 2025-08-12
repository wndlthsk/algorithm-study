// nxm 크기의 공간에 아기상어 여러 마리, 공간은 1x1 크기, 한칸에 최대 1마리
// 안전 거리: 그 칸과 가장 거리가 가까운 아기 상어와의 거리이다.
// 거리: 한 칸에서 다른 칸으로 가기 위해 지나야하는 칸의 수, 이동은 8방향가능
// 안전 거리의 최댓값 구하기

// bfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] place = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (place[i][j] == 0) {
                    place[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
//        System.out.println(Arrays.deepToString(place));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bfs(place, n, m, i, j);
            }
        }
        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int result = 0;

    public static void bfs(int[][] place, int n, int m, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{i, j, 0});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (place[x][y] == 1) {
                result = Math.max(result, now[2]);
                break;
            }
            for (int d=0; d<8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, now[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}