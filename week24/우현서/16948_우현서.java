import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[] dx = new int[] {-2, -2, 0, 0, 2, 2};
        int[] dy = new int[] {-1, 1, -2, 2, -1, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{r1, c1, 0});
        visited[r1][c1] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int count = now[2];
            if (r == r2 && c == c2) {
                System.out.println(count);
                return;
            }
            for (int d=0; d<6; d++) {
                int nx = r + dx[d];
                int ny = c + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, count+1});
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println("-1");
    }

}