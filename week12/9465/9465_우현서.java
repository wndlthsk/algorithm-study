// 스티커는 2행 n열로 배치됨
// 하나 떼면 4방향 스티커도 사용 불가
// 각 스티커의 점수 있고, 최대 점수가 되도록 스티커 떼기
// dp[i][j]: i, j까지 해당 스티커 뗐을 때 최대 점수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            stickers = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n+1; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            System.out.println(Arrays.deepToString(stickers));

            int[][] dp = new int[2][n+1];
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}