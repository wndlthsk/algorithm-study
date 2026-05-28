// 영역: 4방향 같은 색상 공간
// 영역 개수, 가장 큰 영역의 넓이 구하기


import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int n, m;
    int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        this.n = n;
        this.m = m;
        this.picture = picture;

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                if (picture[i][j] == 0) continue;
                numberOfArea++;
                int x = bfs(i, j, visited);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, x);
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;


        return answer;
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    private int bfs(int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, 1});
        visited[i][j] = true;
        int value = picture[i][j];
        int count = 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int d=0; d<4; d++) {
                int ni = now[0] + dx[d];
                int nj = now[1] + dy[d];

                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
                if (visited[ni][nj]) continue;
                if (picture[ni][nj] != value) continue;

                queue.add(new int[]{ni, nj, now[2]+1});
                visited[ni][nj] = true;
                count++;
            }
        }

        return count;
    }
}