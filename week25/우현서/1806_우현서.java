import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        // dp[i]: i까지의 합
        int[] dp = new int[n+1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
            dp[i+1] = sum;
        }

//        System.out.println(Arrays.toString(dp));

        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        while (true) {
            int total = dp[right] - dp[left];
            if (total >= s) {
                result = Math.min(result, right - left);
                left++;
            } else if (right == n) {
                break;
            } else {
                right++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(result);
        }

    }

}