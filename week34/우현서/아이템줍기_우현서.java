// 다각형 둘레 따라서 이동, 중간에 비어도 가장 바깥쪽 테두리
// 아이템 줍기위해 이동해야하는 가장 짧은 거리 리턴
// rectangle: [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y] 직사각형 정보
// characterX, characterY : 초기 캐릭터 위치
// itemX, itemY : 아이템 위치

// 바깥 테두리 좌표들 구하기
// 현재위치에서 아이템 위치까지 bfs
// [[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]
// 왼상단, 우하단
// 좌표 그대로 쓰면 1차이 나는 곳에 바로 이어진 상태로 됨.-> 좌표 전체를 2배로 두기

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int maxR;
    int maxC;
    int[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rec: rectangle) {
            maxR = Math.max(maxR, rec[2]);
            maxC = Math.max(maxC, rec[3]);
        }
        maxR *= 2;
        maxC *= 2;
        System.out.println(maxR + " " + maxC);
        // boolean[][] map = new boolean[maxR+1][maxC+1];
        map = new int[maxR+1][maxC+1];

        for (int[] rec: rectangle) {
            int lr = 2*rec[0];
            int lc = 2*rec[1];
            int rr = 2*rec[2];
            int rc = 2*rec[3];

            for (int i=lc; i<=rc; i++) {
                map[lr][i] = 1;
                map[rr][i] = 1;
            }
            for (int i=lr; i<=rr; i++) {
                map[i][lc] = 1;
                map[i][rc] = 1;
            }
        }

        for (int[] rec: rectangle) {
            int lr = 2*rec[0];
            int lc = 2*rec[1];
            int rr = 2*rec[2];
            int rc = 2*rec[3];

            for (int i=lr+1; i<rr; i++) {
                for (int j=lc+1; j<rc; j++) {
                    map[i][j] = 0;
                }
            }
        }
        // for (int[] m: map) {
        //     System.out.println(Arrays.toString(m));
        // }

        int answer = bfs(2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);


        return answer;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int bfs(int i, int j, int ti, int tj) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maxR+1][maxC+1];
        visited[i][j] = true;
        queue.add(new int[]{i, j, 0}); // x,y,카운트

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];

            if (x == ti && y == tj) {
                return count/2;
            }

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx > maxR || ny < 0 || ny > maxC ) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                queue.add(new int[]{nx, ny, count+1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}