// (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
// 으로 이동 가능
// nxn, (r1, c1)에서 (r2, c2)이동하는 최소 이동 횟수 구하기
// 0-based
// 이동할 수 없으면 -1

// 6방향 이동 가능, 최소 이동 횟수 구하는 문제이므로 bfs 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r1][c1] = true;
        queue.add(new int[]{r1, c1, 0});

        int[] dx = {-2, -2, 0, 0, 2, 2};
        int[] dy = {-1, 1, -2, 2, -1, 1};

        int result = -1;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];
            int count = now[2];

            if (nowR == r2 && nowC == c2) {
                result = count;
                break;
            }

            for (int d=0; d<6; d++) {
                int nr = nowR + dx[d];
                int nc = nowC + dy[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, count+1});
                    }
                }
            }
        }

        System.out.println(result);
    }
}