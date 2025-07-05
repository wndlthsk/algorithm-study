// 수빈 n, 동생 k
// 수빈이는 걷거나 순간이동 가능,
// 걸으면 x-1, x+1로 이동 가능, 순간이동하면 2*x위치로 이동
// 수빈이가 동생 찾을 수 있는 최소 시간


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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n,k));
    }

    static private int bfs(int n, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0}); // i, 카운트
//        Set<Integer> visited = new HashSet<>();
//        visited.add(n);
        boolean[] visited = new boolean[100001];

        int[] dx = {-1, 1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
//            System.out.println(now[0] + " " + now[1]);
            int x = now[0], count = now[1];
            if (x == k) {
                return count;
            }

            for (int d=0; d<2; d++) {
                int nx = x + dx[d];
                if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                    queue.add(new int[]{nx, count+1});
                    visited[nx] = true;
                }
            }

            int nx = x + x;
            if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                queue.add(new int[]{nx, count+1});
                visited[nx] = true;
            }
        }

        return -1;
    }
}