import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// nx2 우리
// 가로로, 세로로 붙어있게 배치 x
// 사자 배치하는 경우의 수 구하기

// dp[n][3] : 0:빈 상태, 1: 왼쪽 배치, 2: 오른쪽 배치 일때 경우의 수
// dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
// dp[i][1] = dp[i-1][0] + dp[i-1][2]
// dp[i][2] = dp[i-1][0] + dp[i-1][1]
// result = dp[n][0] + dp[n][1] + dp[n][2]

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        int result = dp[n][0] + dp[n][1] + dp[n][2];
        System.out.println(result % 9901);

    }
}