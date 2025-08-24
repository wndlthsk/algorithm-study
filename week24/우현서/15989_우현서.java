import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            // dp[i]: i를 만드는 방법의 수
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int j = 1; j <= 3; j++) {
                for (int k = j; k <= n; k++) {
                    dp[k] += dp[k-j];
                }
            }
            System.out.println(dp[n]);
        }
    }

}