// nxm 맵, 0: 이동가능, 1: 벽
// (1,1) -> (n,m) 최단 경로
// 벽을 k개까지 부숴도 됨, 4방향

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maps;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        maps = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                maps[i][j] = input.charAt(j) - '0';
            }
        }
//        System.out.println(Arrays.deepToString(maps));
        System.out.println(bfs(0,0));

    }

    static private int bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, 1, 0}); // i, j, 이동칸 카운트, 벽 카운트
        boolean[][][] visited = new boolean[k+1][n][m];
        visited[0][i][j] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1], count = now[2], wall = now[3];
            if (x == n-1 && y == m-1) {
                return count;
            }

            for (int d=0; d<4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx>=0 && nx<n && ny>=0 && ny<m) {
                    // 벽 아닌곳, 부술 필요 없음
                    if (!visited[wall][nx][ny] && maps[nx][ny] == 0) {
                        visited[wall][nx][ny] = true;
                        queue.add(new int[]{nx, ny, count+1, wall});
                    }
                    // 벽이면 k이하일때 큐에 넣음
                    if(wall < k && !visited[wall+1][nx][ny] && maps[nx][ny] == 1) {
                        visited[wall+1][nx][ny] = true;
                        queue.add(new int[]{nx, ny, count+1, wall+1});
                    }
                }
            }
        }

        return -1;
    }
}