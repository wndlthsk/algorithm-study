import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// s개의 곡, 각 곡은 세사람 중 적어도 한명이 불러야함. 2명/3명도 가능
// 앨범 만들수 있는 방법의 수 구하기
// 1,000,000,007로 나눈 나머지를 출력

// dp[i][a][b][c]: ii번째 곡까지 A가 a번, B가 b번, C가 c번 부른 경우의 수
// dp[i][a][b][c] = dp[i-1]

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[][][][] dp = new long[s+1][A+1][B+1][C+1];
        dp[0][0][0][0] = 1;

        for (int i = 1; i <= s; i++) {
            for (int a = 0; a <= A; a++) {
                for (int b = 0; b <= B; b++) {
                    for (int c = 0; c <= C; c++) {
                        long prev = dp[i-1][a][b][c];
                        if (prev == 0) continue;

                        // 1명
                        if (a+1 <= A) dp[i][a+1][b][c] = (dp[i][a+1][b][c] + prev) % MOD;
                        if (b+1 <= B) dp[i][a][b+1][c] = (dp[i][a][b+1][c] + prev) % MOD;
                        if (c+1 <= C) dp[i][a][b][c+1] = (dp[i][a][b][c+1] + prev) % MOD;

                        // 2명
                        if (a+1 <= A && b+1 <= B)
                            dp[i][a+1][b+1][c] = (dp[i][a+1][b+1][c] + prev) % MOD;
                        if (a+1 <= A && c+1 <= C)
                            dp[i][a+1][b][c+1] = (dp[i][a+1][b][c+1] + prev) % MOD;
                        if (b+1 <= B && c+1 <= C)
                            dp[i][a][b+1][c+1] = (dp[i][a][b+1][c+1] + prev) % MOD;

                        // 3명
                        if (a+1 <= A && b+1 <= B && c+1 <= C)
                            dp[i][a+1][b+1][c+1] = (dp[i][a+1][b+1][c+1] + prev) % MOD;
                    }
                }
            }
        }

        System.out.println(dp[s][A][B][C]);

    }
}