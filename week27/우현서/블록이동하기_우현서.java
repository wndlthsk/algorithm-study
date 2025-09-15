// 로봇: 2x1 크기
// nxn 지도에서 로봇 움직여 n,n까지 이동
// 1,1  1-based
// 0: 빈칸, 1: 벽
// 로봇이 차지하는 두칸 중 어느 한칸이라도 n,n에 도착하면 됨
// 회전하는 영역에 벽 없으면 90도 회전 가능
// 한칸 이동, 90도 회전 : 1초
// 최소 시간 리턴

// bfs
// 할 수 있는게 90도 회전(4경우), 이동(4경우)

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        // System.out.println(n);

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][n][n][n];
        queue.add(new int[]{0, 0, 0, 1, 0}); // x1, y1, x2, y2, 시간
        visited[0][0][0][1] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] dir = {-1, 1};

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x1 = now[0];
            int y1 = now[1];
            int x2 = now[2];
            int y2 = now[3];
            int time = now[4];
            if ((x1 == n-1 && y1 == n-1) || (x2 == n-1 && y2 == n-1)) {
                answer = time;
                break;
            }

            // 이동
            for (int d = 0; d < 4; d++) {
                int nx1 = x1 + dx[d];
                int ny1 = y1 + dy[d];
                int nx2 = x2 + dx[d];
                int ny2 = y2 + dy[d];

                if (isValid(nx1, ny1, board, n) && isValid(nx2, ny2, board, n)) {
                    if (!visited[nx1][ny1][nx2][ny2]) {
                        queue.add(new int[]{nx1, ny1, nx2, ny2, time+1});
                        visited[nx1][ny1][nx2][ny2] = true;
                    }
                }
            }

            // 회전
            // 로봇이 가로로 있을 때
            if (x1 == x2) {
                // 왼쪽 기준
                // 아래로 회전 (오른쪽 대각선 아래가 비어있어야함)
                // 위로 회전 (오른쪽 대각선 위가 비어있어야함)

                // 오른쪽 기준
                // 아래로 회전 (왼쪽 대각선 아래가 비어있어야함)
                // 위로 회전 (왼쪽 대각선 위가 비어있어야함)
                for (int d: dir) {
                    if (isValid(x2+d, y2, board, n) && isValid(x1+d, y1, board, n)) {
                        tryAdd(x1, y1, x1+d, y1, time, visited, queue);
                        tryAdd(x2+d, y2, x2, y2, time, visited, queue);
                    }
                }

            } else if (y1 == y2) { // 로봇이 세로로 있을 때
                // 위쪽 기준
                // 왼쪽으로 회전 (왼쪽 대각선 아래가 비어있어야함)
                // 오른쪽으로 회전

                // 아래쪽 기준
                // 왼쪽으로 회전
                // 오른쪽으로 회전
                for (int d: dir) {
                    if (isValid(x2, y2+d, board, n) && isValid(x1, y1+d, board, n)) {
                        tryAdd(x1, y1, x1, y1+d, time, visited, queue);
                        tryAdd(x2, y2+d, x2, y2, time, visited, queue);
                    }
                }
            }
        }

        return answer;
    }

    private boolean isValid(int x, int y, int[][] board, int n) {
        if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0) return true;
        return false;
    }

    private void tryAdd(int nx1, int ny1, int nx2, int ny2, int time, boolean[][][][] visited, Queue<int[]> queue) {
        // 항상 (x1,y1) <= (x2,y2) 순서로 정렬해서 중복 방지
        if (nx1 > nx2 || (nx1 == nx2 && ny1 > ny2)) {
            int tx = nx1, ty = ny1;
            nx1 = nx2; ny1 = ny2;
            nx2 = tx; ny2 = ty;
        }

        if (!visited[nx1][ny1][nx2][ny2]) {
            visited[nx1][ny1][nx2][ny2] = true;
            queue.add(new int[]{nx1, ny1, nx2, ny2, time+1});
        }
    }
}