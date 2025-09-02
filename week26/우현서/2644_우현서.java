import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> relation = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            relation.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation.get(x).add(y);
            relation.get(y).add(x);
        }

        int result = bfs(a, b, n, relation);
        System.out.println(result);
    }

    public static int bfs(int a, int b, int n, List<List<Integer>> relation) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{a, 0}); // 현재, 카운트
        boolean[] visited = new boolean[n+1];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int count = now[1];
            if (x == b) {
                return count;
            }

            for (int num : relation.get(x)) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(new int[]{num, count+1});
                }
            }
        }

        return -1;
    }

}