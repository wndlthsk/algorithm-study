// 각 빈칸, 퍼즐을 0,0 기준으로 저장해서 회전하면서 비교

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    int n;

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        // 빈칸 구하기
        List<List<int[]>> empty = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                if (game_board[i][j] == 1) continue;

                List<int[]> p = bfs(i, j, visited, game_board, 0);
                empty.add(change(p));
            }
        }

        // for (List<int[]> e: empty) {
        //     for (int[] a: e) {
        //         System.out.print(Arrays.toString(a));
        //     }
        //     System.out.println();
        // }

        // 퍼즐 구하기
        List<List<int[]>> puzzle = new ArrayList<>();
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                if (table[i][j] == 0) continue;

                List<int[]> p = bfs(i, j, visited, table, 1);
                puzzle.add(change(p));
            }
        }

        // for (List<int[]> p: puzzle) {
        //     for (int[] a: p) {
        //         System.out.print(Arrays.toString(a));
        //     }
        //     System.out.println();
        // }

        // 빈칸이랑 퍼즐 비교
        int answer = 0;
        boolean[] donePuzzle = new boolean[puzzle.size()];

        for (List<int[]> e: empty) {
            for (int i=0; i<puzzle.size(); i++) {
                if (donePuzzle[i]) continue;

                List<int[]> p = puzzle.get(i);
                if(e.size() != p.size()) continue;

                boolean found = false;
                for (int r=0; r<4; r++) {
                    boolean possible = true;

                    for (int k=0; k<e.size(); k++) {
                        if (e.get(k)[0] != p.get(k)[0] || e.get(k)[1] != p.get(k)[1]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        answer += e.size();
                        donePuzzle[i] = true;
                        found = true;
                        break;
                    }

                    p = change(rotate(p));

                }

                if (found) break;
            }
        }

        return answer;
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    private List<int[]> bfs(int i, int j, boolean[][] visited, int[][] board, int value) {
        Queue<int[]> q = new ArrayDeque<>();

        visited[i][j] = true;
        q.add(new int[]{i, j});

        List<int[]> puzzle = new ArrayList<>();
        puzzle.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int d=0; d<4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != value) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                puzzle.add(new int[]{nx, ny});
            }
        }

        return puzzle;
    }


    private List<int[]> change(List<int[]> puzzle) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] p: puzzle) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }


        List<int[]> newPuzzle = new ArrayList<>();
        for (int[] p: puzzle) {
            newPuzzle.add(new int[]{p[0] - minX, p[1] - minY});
        }

        newPuzzle.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        return newPuzzle;
    }


    private List<int[]> rotate(List<int[]> puzzle) {
        List<int[]> newPuzzle = new ArrayList<>();
        for (int[] p: puzzle) {
            newPuzzle.add(new int[]{p[1], -p[0]});
        }

        return newPuzzle;
    }


}