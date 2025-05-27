// 빨, 파 구슬 넣고 빨 구슬을 빼내는 게임
// n x m, 파 구슬이 구멍에 들어가면 안됨
// 4방향 기울이기 가능
// .: 빈칸, #: 장애물 or 벽, O: 구멍, R: 빨 구슬, B: 파 구슬
// 각 동작에서 공은 동시에 움직임. 빨간 구슬만 구멍에 빠져야 성공
// 10번 이하로 가능한지 여부

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char [n][m];
        int[] red = null;
        int[] blue = null;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'R') {
                    red = new int[] {i, j};
                } else if (board[i][j] == 'B') {
                    blue = new int[] {i, j};
                }
            }
        }
//        System.out.println(Arrays.deepToString(board));

        System.out.println(bfs(red, blue, n, m));
    }

    static int bfs(int[] red, int[] blue, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        queue.add(new int[]{red[0], red[1], blue[0], blue[1], 0});
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int rx = now[0], ry = now[1], bx = now[2], by = now[3], count = now[4];

            if (count >= 10) break;

            for (int d=0; d<4; d++) {
                int[] newRed = move(rx, ry, dx[d], dy[d]);
                int[] newBlue = move(bx, by, dx[d], dy[d]);

                int newRx = newRed[0], newRy = newRed[1], newRcount = newRed[2];
                int newBx = newBlue[0], newBy = newBlue[1], newBcount = newBlue[2];

                // 파란게 구멍이면 패스
                if(board[newBx][newBy] == 'O') continue;

                // 빨간 구슬이 구멍이면
                if (board[newRx][newRy] == 'O') return 1;

                // 같은 곳에 도착하면 늦게 온 하나는 한칸 되돌림
                if (newRx == newBx && newRy == newBy) {
                    if (newRcount > newBcount) {
                        newRx -= dx[d];
                        newRy -= dy[d];
                    } else {
                        newBx -= dx[d];
                        newBy -= dy[d];
                    }
                }

                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new int[]{newRx, newRy, newBx, newBy, count+1});
                }
            }
        }

        return 0;
    }

    static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
            cnt++;
        }
        return new int[]{x, y, cnt};
    }
}