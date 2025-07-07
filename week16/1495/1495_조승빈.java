import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            for (int vol = 0; vol <= M; vol++) {
                if (dp[i][vol]) {
                    if (vol + arr[i] <= M) {
                        dp[i + 1][vol + arr[i]] = true;
                    }
                    if (vol - arr[i] >= 0) {
                        dp[i + 1][vol - arr[i]] = true;
                    }
                }
            }
        }

        int ans = -1;
        for (int vol = M; vol >= 0; vol--) {
            if (dp[N][vol]) {
                ans = vol;
                break;
            }
        }

        System.out.println(ans);
    }
}
