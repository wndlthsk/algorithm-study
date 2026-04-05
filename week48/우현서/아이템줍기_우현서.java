import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] board = new int[102][102];
        for (int[] rec: rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
        }


        for (int[] rec: rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x = x1+1; x < x2; x++) {
                for (int y = y1+1; y < y2; y++) {
                    board[x][y] = 0;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[102][102];
        queue.add(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];
            int cnt = now[2];

            if (x == itemX*2 && y == itemY*2) {
                answer = cnt/2;
                break;
            }

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 102 || ny < 0 || ny >= 102) continue;
                if (board[nx][ny] == 0 || visited[nx][ny]) continue;

                queue.add(new int[]{nx, ny, cnt+1});
                visited[nx][ny] = true;
            }
        }

        return answer;
    }
}