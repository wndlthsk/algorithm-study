// n*m 땅
// 석유 여러 덩어리, 시추관 수직으로 하나만 뚫기 가능
// 가장 많은 석유 뽑을 수 있게. 열 하나를 관통

// n만큼 반복? 하나씩 넣어보면서
// 덩어리는 bfs로 크기 구하기? 미리 구해서 저장해두자. 열위치마다

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    int n;
    int m;

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        arr = new int[m]; // column별 누적
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (visited[i][j] || land[i][j] == 0) continue;
                bfs(land, i, j);
            }
        }

        int answer = 0;
        for (int a: arr) {
            answer = Math.max(answer, a);
        }


        return answer;
    }

    int[] arr;


    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    boolean[][] visited;


    public void bfs(int[][] land, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        visited[i][j] = true;
        int total = 0;

        Set<Integer> columns = new HashSet<>();

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            columns.add(now[1]);
            total++;

            for (int d=0; d<4; d++) {
                int ni = now[0] + dx[d];
                int nj = now[1] + dy[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                if (visited[ni][nj] || land[ni][nj] == 0) continue;

                queue.add(new int[]{ni, nj});
                visited[ni][nj] = true;
            }
        }


        for (int c: columns) {
            arr[c] += total;
        }

    }
}