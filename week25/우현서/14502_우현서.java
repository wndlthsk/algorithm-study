import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<int[]> virus = new ArrayList<>();
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) {
                    empty.add(new int[]{i, j});
                }
                else if (x == 2) {
                    virus.add(new int[]{i, j});
                }
                map[i][j] = x;
            }
        }
//        System.out.println(empty);

        combination(new ArrayList<>(), empty, 0);
//        System.out.println(result);

        int max = 0;
        for (List<int[]> combi: result) {
            int[][] copy = new int[n][m];
            for (int i=0; i<n; i++) {
                copy[i] = Arrays.copyOf(map[i], map[i].length);
            }
            // 3개 벽 세우기
            for (int[] node: combi) {
                copy[node[0]][node[1]] = 1;
            }

            // 바이러스 확산
            bfs(copy, virus, n, m);

            // 안전영역 카운트
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 0) {
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }
        System.out.println(max);

    }

    static List<List<int[]>> result = new ArrayList<>();

    public static void combination(List<int[]> now, List<int[]> empty, int start) {
        if (now.size() == 3) {
            result.add(new ArrayList<>(now));
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            now.add(empty.get(i));
            combination(now, empty, i+1);
            now.remove(now.size()-1);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int[][] copy, List<int[]> virus, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] node: virus) {
            queue.add(new int[]{node[0], node[1]});
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m ) {
                    if (copy[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        copy[nx][ny] = 2;
                    }
                }
            }

        }
    }

}