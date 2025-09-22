import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 오르막 수: 수의 자리가 오름차순을 이루는 수
// 인접한 수가 같아도 오름차순으로 침
// 수의 길이가 n일 때, 오르막 수의 개수 구하기
// dp[n][k] : n자리수의 마지막 숫자가 k인 오르막 수의 개수
// dp[n][k] =
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=n; i++) {
            for (int j=0; j<10; j++) {
                for (int k=0; k<=j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
                }
            }
        }

        int result = 0;
        for (int i=0; i<10; i++) {
            result = (result + dp[n][i]) % 10007;
        }
        System.out.println(result);
    }
}