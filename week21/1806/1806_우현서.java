// 10000 이하의 자연수로 이루어진 길이 n짜리 수열
// 이 수열에서 연속된 수들의 부분합 중 합이 s이상되는 것중 가장 짧은 길이 기후가
// 불가능하면 0출력

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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
//        System.out.println(Arrays.toString(sum));

        int left = 0;
        int right = 0;
        int result = n+1;
        while (right < n && left <= right) {
            int temp;
            if (left == 0) {
                temp = sum[right];
            } else {
                temp = sum[right] - sum[left-1];
            }

            if (temp >= s) {
                result = Math.min(result, right-left+1);
                left++;
            } else {
                right++;
            }
        }

        if (result == n+1) {
            System.out.println("0");
        } else {
            System.out.println(result);
        }
    }
}