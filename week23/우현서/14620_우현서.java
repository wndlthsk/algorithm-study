import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] flowerbed;
    static List<int[]> candidates = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        flowerbed = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                flowerbed[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for (int[] f : flowerbed) {
//            System.out.println(Arrays.toString(f));
//        }

        for (int i=2; i<n; i++) {
            for (int j=2; j<n; j++) {
                candidates.add(new int[]{i, j});
            }
        }
        visited = new boolean[candidates.size()];

        combi(0, 0);

        System.out.println(result);
    }

    static int result = Integer.MAX_VALUE;

    public static void combi(int depth, int start) {
        if (depth == 3) {
            result = Math.min(result, calculate());
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            visited[i] = true;
            combi(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static int calculate() {
        int sum = 0;
        boolean[][] used = new boolean[n+1][n+1];

        for (int i=0; i<candidates.size(); i++) {
            if (visited[i]) {
                int x = candidates.get(i)[0];
                int y = candidates.get(i)[1];
                used[x][y] = true;
                sum += flowerbed[x][y];

                for (int d=0; d<4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (used[nx][ny]) { // 겹침
                        return Integer.MAX_VALUE;
                    }

                    sum += flowerbed[nx][ny];
                    used[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}