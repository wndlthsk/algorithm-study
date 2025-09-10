// n개 정수로 이루어진 수열
// 연속된 몇개 선택해서 가장 큰 합 구하기
// dp[i] : i를 마지막으로 하는 부분합ㅂ 최대


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}