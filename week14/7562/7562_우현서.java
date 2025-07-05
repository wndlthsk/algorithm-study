import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            int result = bfs(x, y, l, tx, ty);
            System.out.println(result);
        }

    }

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    private static int bfs(int x, int y, int l, int tx, int ty) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[l][l];
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == tx && now[1] == ty) {
                return now[2];
            }
            for (int i=0; i<8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, now[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}