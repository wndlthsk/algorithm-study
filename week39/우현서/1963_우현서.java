import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 한번에 한자리만 변경 가능
// 소수 2개에서 바꾸는데 필요한 최소 단계 출력
// 1000미만 안됨
// 불가능이면 Impossible 출력

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = bfs(a, b);
            if (result == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(result);
            }
        }
    }

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[100000];
        queue.add(start);
        Arrays.fill(dist, -1);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == target) return dist[now];

            for (int next: getNext(now)) {
                if (isPrime(next) && dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    public static List<Integer> getNext(int x) {
        List<Integer> result = new ArrayList<>();
        char[] chars = String.valueOf(x).toCharArray();

        for (int i = 0; i < 4; i++) {
            char before = chars[i];
            for (char c = '0'; c <= '9'; c++) {
                if (before == c) continue;
                if (i==0 && c == '0') continue;

                chars[i] = c;
                int next = Integer.parseInt(String.valueOf(chars));
                result.add(next);
            }

            chars[i] = before;
        }

        return result;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}