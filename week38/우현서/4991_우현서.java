import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static char[][] arr;
    static List<int[]> nodes; // 시작점, 더러운 칸
    static int[][] distMatrix; // i->j 최단거리
    static int dirtySize;

    static List<Integer> output;
    static boolean[] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) break;

            arr = new char[H][W];
            nodes = new ArrayList<>();

            int startX = -1, startY = -1;

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    char x = s.charAt(j);
                    if (x == 'o') {
                        startX = i;
                        startY = j;
                    } else if (x == '*') {
                        nodes.add(new int[]{i, j});
                    }
                    arr[i][j] = x;
                }
            }

            // 0번 노드는 시작점
            nodes.add(0, new int[]{startX, startY});
            dirtySize = nodes.size() - 1;

            // 1. 모든 쌍의 최단 거리 사전 계산
            boolean possible = precalculateDistances();

            if (!possible) {
                System.out.println(-1);
                continue;
            }

            // 2. 더러운 칸 순서에 대한 순열 생성 (기존 함수 구조 재사용)
            List<List<Integer>> candidates = new ArrayList<>();
            output = new ArrayList<>();
            visited = new boolean[dirtySize];
            permutation(0, dirtySize, dirtySize, candidates);

            // 3. 순열을 따라 총 거리 계산 및 최솟값 갱신
            long result = Long.MAX_VALUE;

            for (List<Integer> candidate : candidates) {
                long sum = 0;

                int firstDirtyIndex = candidate.get(0) + 1;
                sum += distMatrix[0][firstDirtyIndex];

                for (int i = 0; i < candidate.size() - 1; i++) {
                    int fromIndex = candidate.get(i) + 1;
                    int toIndex = candidate.get(i + 1) + 1;
                    sum += distMatrix[fromIndex][toIndex];
                }

                result = Math.min(result, sum);
            }

            System.out.println(result == Long.MAX_VALUE ? -1 : result);
        }
    }

    public static void permutation(int depth, int n, int r, List<List<Integer>> candidates) {
        if (depth == r) {
            candidates.add(new ArrayList<>(output));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output.add(i);
                permutation(depth + 1, n, r, candidates);
                output.remove(output.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static boolean precalculateDistances() {
        int totalNodes = dirtySize + 1;
        distMatrix = new int[totalNodes][totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            for (int j = i + 1; j < totalNodes; j++) {
                int[] start = nodes.get(i);
                int[] end = nodes.get(j);

                int dist = bfs(start[0], start[1], end[0], end[1]);

                if (dist == -1) {
                    return false;
                }

                distMatrix[i][j] = dist;
                distMatrix[j][i] = dist; // 거리 대칭
            }
        }
        return true;
    }

    public static int bfs(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[H][W];

        queue.add(new int[]{sx, sy, 0}); // {x, y, 거리}
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int count = now[2];

            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (visited[nx][ny] || arr[nx][ny] == 'x') continue;

                if (nx == tx && ny == ty) {
                    return count + 1;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, count + 1});
            }
        }

        return -1;
    }
}