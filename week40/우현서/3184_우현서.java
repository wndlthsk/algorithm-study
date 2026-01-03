import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// .: 빈 필드, #: 울타리, o: 양, v: 늑대
// 수평/수직으로 이동해 울타리 지나지 않고 이동할 수 있으면 같은 영역
// 탈출할 수 있는 칸은 어떤 영역에도 속하지 않는다
// 영역 안에서 양이 늑대보다 많으면 이김, 늑대 쫓아냄
// 아니면 늑대가 모든 양 먹음
// 살아남은 양과 늑대 수를 출력


public class Main {

    static char[][] arr;
    static int r;
    static int c;
    static int O;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && arr[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(O + " " + V);
    }

    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});

        int countO = 0;
        int countV = 0;
        if (arr[i][j] == 'o') countO++;
        else if (arr[i][j] == 'v') countV++;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == '#') continue;

                if (arr[nx][ny] == 'o') countO++;
                else if (arr[nx][ny] == 'v') countV++;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        if (countO > countV) O += countO;
        else V += countV;
    }
}