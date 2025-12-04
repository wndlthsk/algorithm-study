import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 1~n번 학생, 두명씩 키 비교 결과
// n명 모두 키 다름
// 모든 학생 중 키가 가장 작은 학생부터 자신이 몇번째인지 알 수 있는 학생이 있음
// a->b: 키가 a<b
// 알수 있는 학생 수 구하기


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // dfs/bfs
//        List<List<Integer>> shorter = new ArrayList<>();
//        List<List<Integer>> taller = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            shorter.add(new ArrayList<>());
//            taller.add(new ArrayList<>());
//        }
        boolean[][] reachable = new boolean[n+1][n+1];


        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // dfs/bfs
//            shorter.get(b).add(a);
//            taller.get(a).add(b);
            reachable[a][b] = true;
        }

        int result = 0;

        // 플로이드
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=1; j<=n; j++) {
                if (i==j) continue;
                if (reachable[i][j]) count++; // i보다 큰사람 수
                if (reachable[j][i]) count++; // i보다 작은 사람 수
            }
            if (count == n-1) result++;
        }


        // bfs
//        for (int i = 1; i <= n; i++) {
//            int t = bfs(i, taller);
//            int s = bfs(i, shorter);
//
//            if (t+s == n-1) {
//                result++;
//            }
//        }

        // dfs
//        for (int i=1; i<=n; i++) {
//            boolean[] visited = new boolean[n+1];
//            visited[i] = true;
//            int t = dfs(i, taller, visited);
//            int s = dfs(i, shorter, visited);
//
//            if (t+s == n-1) {
//                result++;
//            }
//        }

        System.out.println(result);
    }

    public static int bfs(int now, List<List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];
        queue.add(now);
        visited[now] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int next: graph.get(x)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }

        return count;
    }

    public static int dfs(int now, List<List<Integer>> graph, boolean[] visited) {
        int count = 0;

        for (int next: graph.get(now)) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                count += dfs(next, graph, visited);
            }
        }

        return count;
    }
}