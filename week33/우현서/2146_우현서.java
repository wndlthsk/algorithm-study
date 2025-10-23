import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 가장 짧은 다리를 놓아 두 섬을 연결
// 가장 짧은 다리의 길이 출력
// 0: 바다, 1: 육지

// 섬마다의 테두리를 구하기, 각 테두리에서 다른 테두리까지 길이 갱신

public class Main {
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> edges = new ArrayList<>();
        int[][] island = new int[n][n];
        int islandNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandNum++;
                    List<int[]> edge = bfs(i, j, visited, islandNum, island);
                    edges.add(edge);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (List<int[]> edge : edges) {
            // 멀티소스 bfs 사용
//            int dist = bfs2_island(edge, island);
//            result = Math.min(result, dist);

            // 좌표별 bfs 사용
            for (int[] e: edge) {
                int dist = bfs2(e[0], e[1], island);
                result = Math.min(result, dist);
            }
        }

        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 섬 테두리 List<int[]> edges, 섬 구분 island[][] 구하는 bfs
    public static List<int[]> bfs(int i, int j, boolean[][] visited, int islandNum, int[][] island) {
        List<int[]> edges = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            island[x][y] = islandNum;

            if (isEdge(x, y)) {
                edges.add(new int[]{x, y});
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return edges;
    }

    // 각 테두리에서 가장 가까운 다른 섬까지의 거리 (한 좌표마다)
    public static int bfs2(int i, int j, int[][] island) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{i, j, 0});
        visited[i][j] = true;
        int nowIslandNum = island[i][j];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;

                if (island[nx][ny] != 0 && island[nx][ny] != nowIslandNum) {
                    return dist;
                }

                if (island[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist+1});
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    // 각 테두리에서 가장 가까운 다른 섬까지의 거리 (한 섬마다)
    // 멀티소스 bfs, 이 문제는 최소 "거리"를 구하는 거니까 한번에 큐에 다 넣고 시작해도 된다.
    // 근데 경로를 구해야한다면 보완이 필요하다.
    // 멀티소스 bfs는 이론상 더 효율적이지만 bfs 탐색 범위가 넓어서 실제론 더 많은 시간이 소모될 수 있다.
    public static int bfs2_island(List<int[]> edges, int[][] island) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for (int[] e: edges) {
            q.offer(new int[]{e[0], e[1], 0});
            visited[e[0]][e[1]] = true;
        }
        int nowIslandNum = island[edges.get(0)[0]][edges.get(0)[1]];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;

                if (island[nx][ny] != 0 && island[nx][ny] != nowIslandNum) {
                    return dist;
                }

                if (island[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist+1});
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static boolean isEdge(int i, int j) {
        for (int d=0; d<4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            if (map[nx][ny] == 0) return true;
        }

        return false;
    }

}