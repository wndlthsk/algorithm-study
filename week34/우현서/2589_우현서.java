import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// L: 육지, W: 바다
// 상하좌우 이웃 육질로만 이동 가능, 한칸에 1시간
// 보물은 서로 간 최단거리 이동에 가장 긴 시간 걸리는 육지 두곳에 뭍혀있음
// 같은 곳 두번 이상or 멀리 돌아가면 안됨
// 보물이 묻혀 있는 두 곳 간의 최단 거리 이동 시간 구하기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Character[][] map = new Character[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();
            for (int j=0; j<chars.length; j++) {
                map[i][j] = chars[j];
            }
        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    result = Math.max(result, bfs(r,c,map,i,j));
                }
            }
        }

        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(int r, int c, Character[][] map, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        queue.add(new int[]{i, j, 0});
        visited[i][j] = true;
        int max = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            int dist = now[2];
            max = Math.max(max, dist);

            for (int d=0; d<4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny]) continue;
                if (map[nx][ny] == 'W') continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist+1});
            }
        }

        return max;
    }
}