import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[][] memo = new long[n][21];   // count번째까지 숫자를 확인했을 때 합이 sum이 되는 경우의 수
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dfs(memo, nums, nums[0], 1));

    }

    public static long dfs(long[][] memo, int[] nums, int sum, int count) {
        if (count == nums.length-1) {
            if (sum == nums[nums.length - 1]) {
                return 1;
            }
            else return 0;
        }

        if (memo[count][sum] != -1) return memo[count][sum]; // 중복 계산 방지

        long temp = 0;
        if (sum+nums[count] >= 0 && sum+nums[count] <=20) {
            temp += dfs(memo, nums, sum+nums[count], count+1);
        }
        if (sum-nums[count] >= 0 && sum-nums[count] <= 20) {
            temp += dfs(memo, nums, sum-nums[count], count+1);
        }
        memo[count][sum] = temp;

        return temp;
    }

}