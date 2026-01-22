// 0: 빈곳, 1: 벽
// (0,0) -> (n-1, n-1)
// 4방향 인접한 두 빈칸을 연결
// 상하, 좌오 -> 직선 도로 100원
// 두 직선도로가 직각으로 만나는 곳 -> 코너 500원
// 최소비용

// 비용 누적하면서 구해야하니까 dfs
// 가중 그래프에서의 최단 경로 문제 --> 다익스트라도 가능

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    int n;

    public int solution(int[][] board) {
        n = board.length;

        // dfs + cost
//         cost = new int[n][n][2];
//         for (int[][] co: cost) {
//             for (int[] c: co) {
//                 Arrays.fill(c, Integer.MAX_VALUE);
//             }
//         }
//         cost[0][0][0] = 0; // 상하
//         cost[0][0][1] = 0; // 좌우

//         dfs(board, 0, 0, 0, -1);

//         return Math.min(cost[n-1][n-1][0], cost[n-1][n-1][1]);


        // 다익스트라
        return dijkstra(board);
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // dfs + cost
    int[][][] cost;

    private void dfs(int[][] board, int i, int j, int sum, int dir) {
        if (i == n-1 && j == n-1) return;

        for (int d=0; d<4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];

            if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
            if (board[ni][nj] == 1) continue;

            int newDir = d < 2 ? 0 : 1; // 상하 / 좌우

            int newCost = 0;
            if (dir == -1 || dir == newDir) newCost = sum + 100; // 출발 || 같은 방향일때
            else newCost = sum + 600;

            if (cost[ni][nj][newDir] < newCost) continue; // 이미 같은 방향에서 더 싼 경로가 있으면 패스
            cost[ni][nj][newDir] = newCost; // 싼 경로 값으로 갱신

            dfs(board, ni, nj, newCost, newDir);
        }
    }


    // 다익스트라
    private int dijkstra(int[][] board) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[][][] dist = new int[n][n][2]; // 0: 상하, 1: 좌우
        boolean[][][] visited = new boolean[n][n][2];

        pq.add(new int[]{0, 0, 0, 0}); // x, y, 비용, 방향
        pq.add(new int[]{0, 0, 0, 1});

        for (int[][] di: dist) {
            for (int[] d: di) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0], y = now[1], cost = now[2], dir = now[3];

            if (x == n-1 && y == n-1) return cost;

            if (visited[x][y][dir]) continue;
            visited[x][y][dir] = true;

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] == 1) continue;

                int newDir = d < 2 ? 0 : 1;

                int newCost = cost;
                if (dir == newDir) newCost += 100;
                else newCost += 600;

                if (dist[nx][ny][newDir] < newCost) continue;
                dist[nx][ny][newDir] = newCost;
                pq.add(new int[]{nx, ny, newCost, newDir});
            }
        }

        return -1;
    }
}