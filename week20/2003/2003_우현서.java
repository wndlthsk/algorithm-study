// n개로 된 수열 A에서 i~j까지 합이 M이 되는 경우의 수 구하기

// 2중 for문
// N(1 ≤ N ≤ 10,000), O(N^2) -> 1억이지만 break로 통과가능(?)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                if (sum == m) {
                    count++;
                    break;
                } else if (sum > m) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}