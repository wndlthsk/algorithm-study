// n행 m열 격자, 각 칸에 대각선 방향1, -1
// 각 칸에서 두 삼각형중 하나만 색칠 가능,
// 색칠한 삼각형들이 한변을 공유하면 덩어리가 됨
// 삼각형 덩어리 중 가장 큰 덩어리의 넓이 구하기

// 방향이 1이면, 왼삼각형은 북서 / 오삼각형은 남동
// 방향이 -1이면, 왼삼각형은 남서 / 오삼각형은 북동

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int n;
    int m;

    public int solution(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int result = 0;

        // boolean으로만 관리하면 한 칸에서 어느 삼각형을 선택했을때 최댓값인지 보장이 안됨
        // -> 같은 덩어리에 숫자를 부여해서 관리
        int[][][] visited = new int[n][m][2];
        int groupNum = 1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=0; k<2; k++) { // 한칸의 삼각형은 (대각선 방향 1)0/1 (대각선 방향 -1)0\1 로 가정함. 이때 k가 0,1을 나타냄
                    if (visited[i][j][k] == 0) { // 아무 그룹에 속하지 않은 삼각형이면
                        result = Math.max(result, bfs(grid, visited, groupNum, i, j, k));
                        groupNum++;
                    }
                }
            }
        }

        return result;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int bfs(int[][] grid, int[][][] visited, int groupNum, int si, int sj, int sk) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{si, sj, sk});
        visited[si][sj][sk] = groupNum; // 시작점에 그룹 번호 부여
        int count = 1; // 그룹에 속하는 삼각형 개수

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int i = now[0], j = now[1], k = now[2];

            // 현재 칸의 대각선 방향, 왼/오 삼각형 상태에서 갈 수 있는 방향(4방향 중 2방향)
            for (int d: getMoves(grid[i][j], k)) {
                int ni = i + dx[d];
                int nj = j + dy[d];
                if (ni <0 || ni >= n || nj < 0 || nj >= m) continue;

                int nk = getNextK(d, grid[ni][nj]);

                // 다음 칸의 삼각형 두개 중 하나라도 이미 그룹에 속했으면 넘김
                // (한바퀴 돌아서 한칸의 두 삼각형이 다 선택될 수 있으니까 두 삼각형을 모두 고려해야함)
                if (visited[ni][nj][nk] == groupNum || visited[ni][nj][1-nk] == groupNum) continue;

                count++;
                queue.add(new int[]{ni, nj, nk});
                visited[ni][nj][nk] = groupNum; // 다음 칸에 현재 그룹 번호 부여
            }
        }

        return count;
    }


    public int[] getMoves(int dir, int k) { // 현재 칸의 대각선 방향, 현재 k
        if (dir == 1 && k == 0) return new int[]{0, 2};
        else if (dir == 1 && k == 1) return new int[]{1, 3};
        else if (dir == -1 && k == 0) return new int[]{1, 2};
        else if (dir == -1 && k == 1) return new int[] {0, 3};

        return null;
    }

    public int getNextK(int d, int nd) { // 동서남북, 다음 칸의 대각선 방향
        if (d == 0 && nd == 1) return 1;
        if (d == 0 && nd == -1) return 0;
        if (d == 1 && nd == 1) return 0;
        if (d == 1 && nd == -1) return 1;
        if (d == 2 && nd == 1) return 1;
        if (d == 2 && nd == -1) return 1;
        if (d == 3 && nd == 1) return 0;
        if (d == 3 && nd == -1) return 0;

        return -1;
    }
}