// s-직진 / l-좌회전 / r-우회전 / 끝 넘어가면 반대쪽 끝으로
// 각 사이클 길이 오름차순 배열 구하기


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        char[][] board = new char[n][m];
        for (int i=0; i<n; i++) {
            board[i] = grid[i].toCharArray();
        }
        // System.out.println(Arrays.deepToString(board));

        int[] dx = {-1, 0, 1, 0}; // 상우하좌
        int[] dy = {0, 1, 0, -1};
        boolean[][][] visited = new boolean[n][m][4];
        List<Integer> result = new ArrayList<>();

        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {
                for (int d=0; d<4; d++) {
                    if (!visited[x][y][d]) {
                        int nx = x;
                        int ny = y;
                        int nd = d;
                        int count = 0;


                        while (!visited[nx][ny][nd]) {
                            visited[nx][ny][nd] = true;
                            count++;

                            char c = board[nx][ny];

                            if (c == 'L') {
                                nd = (nd + 1) % 4;
                            } else if (c == 'R') {
                                nd = (nd + 3) % 4;
                            }

                            nx += dx[nd];
                            ny += dy[nd];


                            nx = (nx + n) % n;
                            ny = (ny + m) % m;

                        }

                        result.add(count);
                    }
                }
            }
        }

        // System.out.println(result);

        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }
}