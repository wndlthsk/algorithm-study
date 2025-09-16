import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[i] : i번 눌렀을 때 최대 A개수
        // dp[i] = dp[i-1] + 1 or dp[j]*(i-j-3+1)
        long[] dp = new long[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j=0; j < i-3; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i-j-3+1+1));
            }
        }
        System.out.println(dp[n]);

    }
}