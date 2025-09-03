// 상대 진영에 빨리 도착해야함
// 1-based, 4방향
// 0: 벽, 1: 이동가능
// 지나야하는 칸의 최소 개수 리턴, 도착할 수 없으면 -1 리턴
// (1,1) -> (n,m)

// bfs로 최단 경로 구하기

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{0, 0, 1}); // x, y, 카운트
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];

            if (x == n-1 && y == m-1) {
                answer = count;
                break;
            }

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    if (maps[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny, count+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return answer;
    }

}