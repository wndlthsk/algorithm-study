import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 자연수 n을 제곰수들의 합으로 표현할 때 항의 최소 개수 구하기
// dp[n] = min(dp[n-k^2] + 1)

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k*k <= i; k++) {
                dp[i] = Math.min(dp[i], dp[i - k*k] + 1);
            }
        }

        System.out.println(dp[n]);
    }

}