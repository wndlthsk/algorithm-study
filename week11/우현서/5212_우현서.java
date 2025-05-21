// r x c 지도, x: 땅/ .: 바다
// 50년 후 인접 3 or 4칸에 바다가 있는 땅은 잠김
// 지도는 모든 섬을 포함하는 가장 작은 직사각형

import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] maps = new char[r][c];
        for (int i=0; i<r; i++ ) {
            String input = br.readLine();
            for (int j=0; j<c; j++ ) {
                maps[i][j] = input.charAt(j);
            }
        }

        var dx = new int[]{-1, 1, 0, 0};
        var dy = new int[]{0, 0, -1, 1};
        List<Point> points = new ArrayList<>();

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                int count = 0;
                if (maps[i][j] == 'X') {
                    for (int k=0; k<4; k++) {
                        var nx = i + dx[k];
                        var ny = j + dy[k];
                        if ((nx >= 0 && nx < r && ny >= 0 && ny < c) && (maps[nx][ny] == '.')) count++;
                        else if (nx < 0 || ny < 0 || nx >= r || ny >= c) count++;
                    }
                }
                if (count >= 3) {
                    points.add(new Point(i, j));
                }
            }
        }

        for (Point p : points) {
            maps[p.x][p.y] = '.';
        }

        int minRow = r, maxRow = 0;
        int minCol = c, maxCol = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (maps[i][j] == 'X') {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        for (int i=minRow; i<=maxRow; i++) {
            for (int j=minCol; j<=maxCol; j++) {
                System.out.print(maps[i][j]);
            }
            System.out.println();
        }
    }
}