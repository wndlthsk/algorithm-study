// nxn 꽃밭, 씨앗 심으면 4방향, 씨앗 3개
// 서로 안닿고, 화단 밖으로 안나가게 심어야함
// 꽃 하나당 5평 대여, 최소 비용 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int n;
    static int[][] prices;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prices = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                prices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(prices));

        dfs(0, 0);
        System.out.println(result);

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void dfs(int count, int sum) {
        if (count == 3) {
            result = Math.min(result, sum);
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // (i, j)에 심을 수 있으면
                if (isPossible(i, j)) {
                    // 방문처리
                    visited[i][j] = true;
                    for (int d=0; d<4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        visited[ni][nj] = true;
                    }

                    // 재귀
                    dfs(count+1, sum + calculatePrice(i, j));

                    // 초기화
                    visited[i][j] = false;
                    for (int d=0; d<4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        visited[ni][nj] = false;
                    }
                }
            }
        }
    }

    public static boolean isPossible(int x, int y) {
        if (visited[x][y]) return false;
        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) return false;
            if (visited[nx][ny]) return false;
        }

        return true;
    }

    public static int calculatePrice(int x, int y) {
        int sum = prices[x][y];
        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            sum += prices[nx][ny];
        }

        return sum;
    }

}