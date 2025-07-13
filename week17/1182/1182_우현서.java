// n개 정수로 이루어진 수열에서
// 크기가 양수인 부분 수열의 총합이 s가 되는 경우의 수 구하기

// 부분 수열 -> 백트래킹으로 넣었다 빼면서, 합이 s될때 카운팅

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] nums;
    static int n;
    static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(nums));
        backtrack(0, 0);
        System.out.println(result);
    }

    static int result;

    public static void backtrack(int sum, int start) {
        if (!(sum==0 && start==0) && sum == s) { // 첫 공집합은 제외
            result++;
        }

        for (int i=start; i<n; i++) {
            sum += nums[i];
            backtrack(sum, i+1);
            sum -= nums[i];
        }
    }
}