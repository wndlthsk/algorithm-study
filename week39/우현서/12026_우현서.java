import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 보도블록 n개, 1~n번
// 스타트집 1번, 링크집 n번
// 각 보도블록에 boj, 1번은 b
// k칸만큼 접프하는데 필요한 에너지양 = k*k
//boj 순서로 밟으면서 점프
// 스타트가 링크 만나는데 필요한 에너지의 최솟값
// 만날 수 없으면 -1
// dp[i] : i번째까지 필요한 에너지 최솟값
// dp[i] = min(dp[j] + (i-j) * (i-j))

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] arr = new char[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = s.charAt(i-1);
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i=1; i<=n; i++) {
            char now = arr[i];
            char before;
            if (now == 'B') {
                before = 'J';
            } else if (now == 'O') {
                before = 'B';
            } else {
                before = 'O';
            }
            for (int j=1; j<=i; j++) {
                if (arr[j] == before && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j));
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(dp[n]);
        }

    }
}