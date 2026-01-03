import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// nxm 모눈 종이에 치즈
// 4변 중 2변 이상이 공기와 접촉한 것은 1시간만에 없어짐
// 치즈 내부 공간에 있는 공간은 외부 공기와 접촉하지 않는 것으로 가정
// 치즈가 모두 없어지는데 걸리는 시간 구하기
// 1: 치즈, 0: 없음

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int time = 0;

        while (true) {
            boolean[][] visited = new boolean[n][m];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0, 0});
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int x = now[0], y = now[1];

                for (int d=0; d<4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (visited[nx][ny] || arr[nx][ny] != 0) continue;

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }

            int total0 = 0;
            List<int[]> melt = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        total0++;
                        int cnt = 0;
                        for (int d=0; d<4; d++) {
                            int nx = i + dx[d], ny = j + dy[d];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visited[nx][ny]) cnt++;
                        }
                        if (cnt >= 2) {
                            melt.add(new int[]{i, j});
                        }
                    }
                }
            }

            for (int[] me: melt) {
                arr[me[0]][me[1]] = 0;
            }

            if (total0 == 0) break;
            time++;
        }

        System.out.println(time);
    }

}