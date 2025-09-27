package week29.우현서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열 A의 증가하는 부분 수열 중 가장 합이 큰 거 구하기
// dp[i] : i번째를 마지막 원소로 하는 증가 부분 수열의 최댓값
// dp[i] = a[i] + max(a[i]보다 작은 a[j]에 중 dp[j])

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j=0; j<i; j++) {
                if (a[i] > a[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = a[i] + max;
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }

}