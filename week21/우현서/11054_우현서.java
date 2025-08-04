// 바이토닉 수열 :  S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN
// 수열 A가 주어질 때 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이 구하기

// dp1[i] : i를 끝으로 가장 긴 증가 부분 수열 길이
// dp2[i] : i를 시작으로 가장 긴 감소 부분 수열 길이
// 증가 수열 -> 앞에서부터 A[i] < A[j]면 갱신 (i<j)
// 감소 수열 -> 뒤에서부터 A[i] > A[j]면 갱신 (i<j)
// i의 바이토닉 수열 길이 = dp1[i] + dp2[i] -1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
            }
        }
        for (int i=n-1; i>=0; i--) {
            for (int j=n-1; j > i; j--) {
                if (A[j] < A[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            result = Math.max(result, dp1[i] + dp2[i] -1);
        }

        System.out.println(result);
    }
}