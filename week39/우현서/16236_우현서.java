import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// nxn 공간, 물고기 m마리, 상어 1마리
// 상어 초기 크기 2, 1초에 4방향 이동가능
// 상어보다 큰 물고기 칸은 지날 수 없음. 이하는 지나갈 수 있음. 먹는건 미만크기만
// 상어 이동 방향 결정 방법
// 먹을 수 있는 물고기 없으면 도움 요청
// 먹을 수 있는 물고기 1마리면 그 방향
// 1마리 초과이면 거리가 가까운 거 먹으러 감
// 거리는 지나야하는 칸의 최소개수
// 거리 > 가장 위 > 가장 왼쪽 우선순위
// 상어 이동은 1초,
// 자신 크기와 같은 수의 물고기 먹을 때마다 크기가 1씩 증가
// 아기상어가 몇초동안 도움 요청 없이 물고기 먹을 수 있는지 구하기


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 9) {
                    sx = i;
                    sy = j;
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = x;
                }
            }
        }

        int sharkSize = 2;
        int eatCount = 0;
        int totalTime = 0;

        while (true) {
            int[] nextFish = bfs(sx, sy, sharkSize, arr, n);
            if (nextFish == null) break;

            sx = nextFish[0];
            sy = nextFish[1];
            totalTime += nextFish[2];

            arr[nextFish[0]][nextFish[1]] = 0;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(totalTime);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int[] bfs(int sx, int sy, int sharkSize, int[][] arr, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{sx, sy, 0}); // x, y, 거리
        visited[sx][sy] = true;

        int minDist = Integer.MAX_VALUE;
        int bestX = -1, bestY = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            int dist = now[2];

            if (dist > minDist) break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nDist = dist + 1;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] > sharkSize) continue;

                queue.add(new int[]{nx, ny, nDist});
                visited[nx][ny] = true;

                // 먹을 수 있는 물고기 발견
                if (arr[nx][ny] != 0 && arr[nx][ny] < sharkSize) {
                    // 우선순위 판별
                    if (nDist < minDist ||
                        (nDist == minDist && (nx < bestX || (nx == bestX && ny < bestY)))
                    ) {
                        minDist = dist + 1;
                        bestX = nx;
                        bestY = ny;
                    }
                }
            }
        }

        if (bestX == -1 || bestY == -1) return null;

        return new int[]{bestX, bestY, minDist};
    }

}