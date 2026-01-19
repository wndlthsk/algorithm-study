// 직사각형 미로에서 탈출, 칸은 통로/벽, 톨로만 지나갈 수 있음
// 통로 중 한칸은 문, 레버를 당겨서만 이동가능, 레버도 통로들 중 한칸
// 출발지 -> 레버 -> 문
// 한칸 이동에 1초, 최소 시간 구하기
// 탈출할 수 없으면 -1

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int n;
    int m;
    char[][] arr;

    public int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();

        int sx = 0, sy = 0;
        int ex = 0, ey = 0;
        int lx = 0, ly = 0;

        arr = new char[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                char x = maps[i].charAt(j);

                if (x == 'S') {
                    sx = i;
                    sy = j;
                } else if (x == 'E') {
                    ex = i;
                    ey = j;
                } else if (x == 'L') {
                    lx = i;
                    ly = j;
                }

                arr[i][j] = x;
            }
        }
        // System.out.println(Arrays.deepToString(arr));

        int toL = bfs(sx, sy, lx, ly);
        int toE = bfs(lx, ly, ex, ey);

        if (toL == -1 || toE == -1) return -1;
        else return toL+toE;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int bfs(int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new ArrayDeque<>(); // x, y, count
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];

            if (x == tx && y == ty) return count;

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || arr[nx][ny] == 'X')  continue;

                queue.add(new int[]{nx, ny, count+1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}