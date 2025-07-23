// 마지막 두 숫자사이에 =
// 나머지 숫자 사이에 + or -
// 왼쪽부터 계산할때 중간에 나오는 수가 0이상 20 이하여야한다.
// 만들 수 있는 올바른 등식의 수 구하기

// 숫자 사이에 +, - 넣었다 빼면서 최종 값이 마지막 수랑 같으면 카운트한다.
// 중간 값이 범위 밖이면 건너뛴다.
// dfs로 안된다.
// + 메모이제이션을 써서 i번째 숫자에 j합으로 도착한 경우를 한번만 거치도록 한다.

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
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        long[][] visited = new long[n][21];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        long result = dfs(numbers, n, numbers[0], 1, visited);
        System.out.println(result);

    }


    public static long dfs(int[] numbers, int n, int sum, int idx, long[][] visited) {
        if (sum < 0 || sum > 20) {
            return 0;
        }

        if (idx == n-1) { // 마지막 숫자 탐색할때가 되면,
            if (sum == numbers[n-1]) {
                return 1;
            }
            return 0;
        }

        if (visited[idx][sum] != -1) { // 이미 탐색한 거니까 재탐색 필요없음
            return visited[idx][sum];
        }

        long result = 0;
        result += dfs(numbers, n, sum+numbers[idx], idx+1, visited);
        result += dfs(numbers, n, sum-numbers[idx], idx+1, visited);
        visited[idx][sum] = result;

        return result;
    }
}