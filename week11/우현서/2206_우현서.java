// n x m 맵
// 0: 이동 가능, 1: 벽
// (1, 1) -> (n, m)까지 최단 경로
// 벽 한 개 부수기 가능, 4방향 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int bfs(int start, int end, boolean[][][] visited) {
        visited[0][start][end] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, end, 1, 0}); // (x, y, 카운트, 벽 부쉈는지 여부)

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1], cnt = now[2], wall = now[3];
            if(x == n-1 && y == m-1) {
                return cnt;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >=0 && nx < n && ny >= 0 && ny < m) {
                    // 벽 아닌 곳
                    if (!visited[wall][nx][ny] && map[nx][ny] == 0) {
                        visited[wall][nx][ny] = true;
                        queue.add(new int[]{nx, ny, cnt+1, wall});
                    }
                    // 벽인데 부술수 있는 경우
                    if (!visited[1][nx][ny] && wall == 0 && map[nx][ny] == 1) {
                        visited[1][nx][ny] = true;
                        queue.add(new int[]{nx, ny, cnt+1, 1});
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i=0; i<n; i++) {
            String input = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
//        for (int[] row : map) {
//            System.out.println(Arrays.toString(row));
//        }

        boolean[][][] visited = new boolean[2][n][m];
        int result = bfs(0, 0, visited);
        System.out.println(result);

    }
}