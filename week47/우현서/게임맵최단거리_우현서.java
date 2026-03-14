// 4방향 이동, (1,1) -> (n,m)
// 0: 벽, 1: 길
// 지나야하는 칸의 개수 리턴, 불가능하면 -1

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = bfs(maps, n, m);

        return answer;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int bfs(int[][] maps, int n, int m){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int i = now[0];
            int j = now[1];
            int count = now[2];

            if (i==n-1 && j ==m-1) {
                return count;
            }

            for (int d=0; d<4; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];

                if (ni<0 || ni>=n || nj<0 || nj >= m) continue;
                if (visited[ni][nj] || maps[ni][nj] == 0) continue;

                queue.add(new int[]{ni, nj, count+1});
                visited[ni][nj] = true;
            }
        }

        return -1;
    }
}