// 자연수 n개, 질문 m번
// 각 질문은 s, e로 나타낼 수 있다. (1<=s<=e<=n)
// s번째 수부터 e번째까지 수가 팰린드롬을 이루는지를 물어보며,
// 명우는 각질문에 대해 팰린드롬이다 or 아니다 대답해야한다 (팰린드롬: 앞에서나 뒤에서 읽으면 같은 단어)
// 1-based

// dp[i][j] = 수열 i번째~j번째가 팰린드롬이면 true
// 길이 1 -> true
// 길이 2 -> nums[i] == nums[j] -> true
// 길이 3 이상 -> nums[i] == nums[j] && dp[i+1][j-1]==true -> true

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i+1]) {
                dp[i][i+1] = true;
            }
        }
        for (int l = 3; l <= n; l++) {
            for (int i=1; i<=n-l+1; i++) {
                int j = i+l-1;
                if (nums[i] == nums[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(dp[s][e]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}