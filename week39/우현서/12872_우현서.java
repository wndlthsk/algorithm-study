import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n개의 노래가 저장돼있다
// p개 노래를 듣는다.
// 플레이리스트 만드는데, 같은 노래 여러번 넣어도 됨
// 모든 노래를 플리에 추가해야함
// 같은 노래 추가하려면 두 노래 사이에 적어도 m개의 곡이 있어야함
// 플레이리스트 만들 수 있는 경우의 수 1,000,000,007로 나눈 나머지 출력

// 지금까지 사용한 곡수, 플리의 길이가 얼만지
// dp[i][j]: 길이가 i인 플리에 서로 다른 j곡일 때 경우의 수
// 플리에 곡 추가하면 새 노래 추가 or 최근 m곡 안에 없는 이미 쓴 노래
// 새 노래 추가할 때 n-j+1 개 중에 선택, 중복 노래 선택시 j-k개 중 하나
// dp[i][j] = (n-j+1) * dp[i-1][j-1] + (j-m) * dp[i-1][j]

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        long[][] dp = new long[p+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = ((n-j+1) * dp[i-1][j-1]) % 1000000007;
                if (j-m > 0)
                    dp[i][j] += ((j-m) * dp[i-1][j]) % 1000000007;
            }
        }

        System.out.println(dp[p][n] % 1000000007);
    }
}