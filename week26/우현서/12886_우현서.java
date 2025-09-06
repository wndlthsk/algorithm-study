import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = a + b + c;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{a, b});
        boolean[][] visited = new boolean[sum+1][sum+1];
        visited[Math.min(a, b)][Math.max(a, b)] = true;

        int[] dx = {0, 0, 1};
        int[] dy = {1, 2, 2};

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int[] rocks = new int[] {now[0], now[1], sum - now[0] - now[1]};

            if (rocks[0] == rocks[1] && rocks[1] == rocks[2]) {
                System.out.println("1");
                return;
            }

            for (int d = 0; d < 3; d++) {
                int group1 = rocks[dx[d]];
                int group2 = rocks[dy[d]];
                int small = 0;
                int big = 0;

                if (group1 == group2) {
                    continue;
                }

                if (group1 < group2) {
                    small = group1;
                    big = group2;

                } else if (group2 < group1) {
                    small = group2;
                    big = group1;
                }

                if (!visited[small+small][big-small]) {
                    visited[small+small][big-small] = true;
                    queue.add(new int[]{small+small, big-small});
                }

            }
        }

        System.out.println("0");
    }
}