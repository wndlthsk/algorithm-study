// 크리보드에는 버튼 4개
// 1. 화면에 A를 출력한다.
// 2. Ctrl-A: 화면을 전체 선택한다
// 3. Ctrl-C: 전체 선택한 내용을 버퍼에 복사한다
// 4. Ctrl-V: 버퍼가 비어있지 않은 경우에는 화면에 출력된 문자열의 바로 뒤에 버퍼의 내용을 붙여넣는다.
// 크리보드 버튼을 총 n번 눌러 화면에 출력된 a개수의 최댓값 구하기

// bfs
// (누른 버튼 수, 화면의 a개수, 버퍼의 a개수)
// 다음 할 행동이 총 4개
// 누른 버튼 수 == n이면 종료
// -> (cnt, screen, buffer) 조합의 수가 기하급수적으로 증가함
// -> visited[][][])이 반드시 필요 → 메모리 많이 씀
// 단순 탐색보다, 이전에 어떤 선택을 했을 때 이득이 컸는가를 기억해두고 그걸 재활용하는 게 훨씬 효율적임


// dp[i] = 버튼을 i번 눌렀을 때 A 개수의 최댓값
// A 누름: dp[i] = dp[i-1] + 1
// 복붙 -> j번째에서 복사를 시작하면,
// j+1(c-a), j+2(c-c), j+3(c-v) -> dp[i] = dp[j] * (i-j-2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 1; j <= i-3; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 2 + 1));
            }
        }
        System.out.println(dp[n]);
    }
}