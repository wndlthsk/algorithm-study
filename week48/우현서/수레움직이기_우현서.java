// nxm 퍼즐판
// 빨간 수레, 파란 수레
// 각 시작칸에서 도착칸으로 이동해야함
// 4방향 이동 가능
// 풀수 없으면 0 리턴

class Solution {
    boolean[][] redVisited;
    boolean[][] blueVisited;
    int n;
    int m;


    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;

        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];

        // 시작점 찾기
        int rx=0, ry=0, bx=0, by=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maze[i][j] == 1) {
                    rx = i;
                    ry = j;
                } else if (maze[i][j] == 2) {
                    bx = i;
                    by = j;
                }
            }
        }
        // 시작점 방문처리
        redVisited[rx][ry] = true;
        blueVisited[bx][by] = true;

        // dfs
        backtrack(rx, ry, bx, by, maze, 0);
        // System.out.println(result);

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int result = Integer.MAX_VALUE;

    public void backtrack(int rx, int ry, int bx, int by, int[][] maze, int depth) {
        if (depth >= result) return;

        // 둘다 도착했으면 result 갱신
        if (maze[rx][ry] == 3 && maze[bx][by] == 4) {
            result = Math.min(result, depth);
            return;
        }

        // red 방향 이동
        for (int dr=0; dr<4; dr++) {
            int nrx = rx;
            int nry = ry;

            // 아직 도착 안했으면 (도착했으면 nrx, nry를 rx, ry로 그대로 유지)
            if (maze[rx][ry] != 3) {
                nrx = rx + dx[dr];
                nry = ry + dy[dr];

                if (nrx < 0 || nrx >= n || nry < 0 || nry >= m) continue;
                if (redVisited[nrx][nry]) continue;
                if (maze[nrx][nry] == 5) continue;
            }

            // blue 방향 이동
            for (int db=0; db<4; db++) {
                int nbx = bx;
                int nby = by;

                // 아직 도착 안했으면 (도착했으면 nbx, nby를 bx, by로 그대로 유지)
                if (maze[bx][by] != 4) {
                    nbx = bx + dx[db];
                    nby = by + dy[db];

                    if (nbx < 0 || nbx >= n || nby < 0 || nby >= m) continue;
                    if (blueVisited[nbx][nby]) continue;
                    if (maze[nbx][nby] == 5) continue;
                }

                // 서로 같은 곳 이동하면 패스
                if (nrx == nbx && nry == nby) continue;
                // 서로 자리 바뀌면 패스
                if (nrx == bx && nry == by && nbx == rx && nby == ry) continue;


                // 방문 처리 후 dfs & 되돌리기
                redVisited[nrx][nry] = true;
                blueVisited[nbx][nby] = true;

                backtrack(nrx, nry, nbx, nby, maze, depth+1);

                redVisited[nrx][nry] = false;
                blueVisited[nbx][nby] = false;
            }
        }
    }
}