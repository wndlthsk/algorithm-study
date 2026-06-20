// 1이면 석유있는 땅

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    int[][] land;
    int n;
    int m;

    public int solution(int[][] land) {
        this.land = land;

        n = land.length;
        m = land[0].length;

        visited = new boolean[n][m];
        colSum = new int[m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (land[i][j] == 0 || visited[i][j]) continue;
                bfs(i, j);
            }
        }

        int answer = 0;
        for (int x: colSum) {
            answer = Math.max(answer, x);
        }

        return answer;
    }

    boolean[][] visited;
    int[] colSum;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};


    private void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        Set<Integer> cols = new HashSet<>();
        cols.add(j);

        int count = 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d=0; d<4; d++) {
                int ni = now[0] + dx[d];
                int nj = now[1] + dy[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                if (visited[ni][nj] || land[ni][nj] == 0) continue;

                queue.add(new int[]{ni, nj});
                visited[ni][nj] = true;
                cols.add(nj);
                count++;
            }
        }


        for (int y: cols) {
            colSum[y] += count;
        }

    }
}