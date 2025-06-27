// nxm 미로, 각 방에 사탕
// 왼쪽 (1,1), 오른쪽 아래 (n, m)
// 준규 위치: (1,1), (n,m)으로 이동
// (r+1, c), (r, c+1), (r+1, c+1)로 이동 가능 => 아래, 오른쪽, 대각선 오른쪽 아래
// 각 방 방문시 사탕을 가져갈 수 있음
// 가질 수 있는 사탕의 최댓값

// bfs로 최대 사탕 저장하면서 (n,m)으로 이동
// -> 메모리 초과나거나 maxCandies[nx][ny] < maxCandies[x][y] + candies[nx][ny] 이 조건 걸면
// -> 최대 사탕개수 갱신하니까 dp로 풀 수 있음
// dp[i][j] = i,j의 사탕 수 + max (dp[i-1][j], dp[i][j-1], dp[i-1][j-1])

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] candies = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                candies[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(candies));

        int[][] dp = new int[n+1][m+1]; // i, j까지 최대 사탕수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = candies[i][j] + Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
            }
        }
        System.out.println(dp[n][m]);
    }

}