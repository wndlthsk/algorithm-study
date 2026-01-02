import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬유물질 m*n
// 검1: 전류 차단, 흰0: 전류 통함
// 전류는 가장 바깥쪽 흰색에 공급, 4방향 흰색으로 전달
// 안까지 침투 가능한지 판단


public class Main {

//    static List<Taste> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 0) {
                queue.add(new int[]{0, i});
                visited[0][i] = true;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
                if (arr[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[m-1][i]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}