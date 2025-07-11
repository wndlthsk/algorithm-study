// 1xn 미로에서 칸에 적혀있는 숫자 이하만큼 오른쪽으로 점프할 수 있다.
// 가장 왼쪽에서 가장 오른쪽으로 가야한다.
// 최소 몇 번 점프를 해야하는지 구하기
// 갈 수 없다면 -1 리턴

// a<b칸 일때, b칸에 도착하는 최소 점프횟수는 a칸까지의 최소 점프횟수 +알파이므로 dp를 사용
// dp[i] : i번째 칸에 도착까지의 최소 점프 횟수
// dp[i+(1~a[i])] 를 기존 값과 비교해서 min으로 갱신한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(a));

        int[] dp = new int[n];
        Arrays.fill(dp, 1000); // Integer.MAX_INTEGER는 오버플로 가능성있음, 배열 길이최대가 1000이므로
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= a[i]; j++) {
                if (i+j >= n) break;
                dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
            }
        }

        if (dp[n-1] == 1000) {
            System.out.println("-1");
        } else {
            System.out.println(dp[n-1]);
        }
    }
}