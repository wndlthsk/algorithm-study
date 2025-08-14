import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<List<Integer>> friends;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        friends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = i; j < line.length(); j++) {
                if (line.charAt(j) == 'Y') {
                    friends.get(i).add(j);
                    friends.get(j).add(i);
                }
            }
        }
//        System.out.println(friends);

        int result = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            result = Math.max(result, bfs(i));
        }

        System.out.println(result);
    }

    public static int bfs(int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, 0}); // 현재 사람, depth
        int count = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[1] > 2) {
                continue;
            }
            for (int next: friends.get(now[0])) {
                if (!visited[next] && now[1] < 2) {
                    queue.add(new int[]{next, now[1] + 1});
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
}