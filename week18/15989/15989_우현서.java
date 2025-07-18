// 합을 나타낼 때 수는 1개 이상을 사용해야한다.
// 수의 순서만 다른 것은 같은 것으로 친다. ex) 1+3 (3+1)
// 정수 n을 1,2,3d의 합으로 나타내는 방법의 수 구하기

// try1) 조합 구하기랑 같다 -> 백트래킹
// 근데 중복 조합이니까 중복 제거를 위해 오름차순만 허용한다
// 트리 깊이 n, 시간복잡도 : O(조합의 수) -> O(n^2) => 시간초과
// try2) dp[i] : i를 만드는 방법의 수
// dp[i] = dp[i] + dp[i-coin]
// dp[0] = 1 // 아무것도 선택하지 않는 1가지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] coins = new int[]{1,2,3};

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int coin: coins) {
                for (int j=coin; j<=n; j++) {
                    dp[j] += dp[j-coin];
                }
            }
            System.out.println(dp[n]);
        }
    }
}

