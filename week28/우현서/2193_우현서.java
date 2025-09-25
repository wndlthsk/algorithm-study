import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이친수: 0과 1로 이루어진 수 중 0으로 시작 x, 1이 두번 연속 x
// dp[i][j] : 길이가 i일때 마지막이 j인 이친수 개수
// dp[i][0] = dp[i-1][0] + dp[i-1][1]
// dp[i][1] = dp[i-1][0]
// dp[0][j] = 0
// dp[1][0] = 0, [1][1] = 1
// [2][0] = 1, [2][1] = 0

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }

}