// nxn 체스판 특정 위치에 하나의 나이트가 존재함.
// m개의 상대 발의 위치 값이 주어질때 각 상대편 말을 잡기 위한 나이트의 최소 이동 수
// 나이트는 8방향 이동 가능,
// (X-2,Y-1), (X-2,Y+1), (X-1,Y-2), (X-1,Y+2), (X+1,Y-2), (X+1,Y+2), (X+2,Y-1), (X+2,Y+1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        List<Point> enemies = new ArrayList<>();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            enemies.add(new Point(a, b));
        }
//        System.out.println("enemies: " + enemies);

//        System.out.println(Arrays.deepToString(bfs(x, y)));
        int[][] result = bfs(x, y);
        for (Point p : enemies) {
            System.out.print(result[p.x][p.y] + " ");
        }
    }


    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static int[][] bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[n+1][n+1];
        queue.add(new int[] {x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int count = now[2];

            for (int d=0; d<8; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && visited[nx][ny] == 0) {
                    queue.add(new int[] {nx, ny, count+1});
                    visited[nx][ny] = visited[nowX][nowY] + 1;
                }
            }
        }

        return visited;
    }
}