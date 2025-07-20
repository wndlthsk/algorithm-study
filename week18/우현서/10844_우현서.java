// 45656 숫자는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
// 길이가 n인 계단 수가 총 몇개인지 구하기, 1,000,000,000로 나눈 나머지를 출력
// 0으로 시작하는 수는 계단 수가 아니다

// 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98
// dp[i][j] = 길이가 i이고 마지막 숫자가 j인 계단 수 개수
// 길이가 하나 작고, j보다 -1이거나 +1인 숫자에 j를 붙여서 계단수를 추가할 수 있다.
// dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
// 0<= j-1, j+1 <= 9 이여야하고, dp[1] 행을 1로 채운다. (예시 참고)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j-1 >= 0) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % 1000000000;
                if (j+1 <= 9) dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % 1000000000;
            }
        }

        int result = 0;
        for (int i=0; i<=9; i++) {
            result = (result + dp[n][i]) % 1000000000;
        }

        System.out.println(result);
    }
}