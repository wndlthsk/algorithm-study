import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 앞 상자가 뒷 상자보다 크기 작으면 앞 상자를 위에 넣을 수 있다.
// 한번에 넣을 수 있는 최대의 상자 개수 출력


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] boxes = new int[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n]; // dp[i]: i를 마지막으로 했을 때 최대 개수
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}