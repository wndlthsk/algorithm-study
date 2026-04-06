// 게임보드 위에 퍼즐 조각 올리기
// 조각 회전 가능, 새로 넣은 퍼즐 조각과 인접 칸이 비면 안됨
// 총 몇칸 채울 수 있는지 리턴


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    int n;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        n = game_board.length;

        // 게임보드의 빈칸 구하기
        List<List<int[]>> targetEmpty = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (game_board[i][j] == 1 || visited[i][j]) continue;

                List<int[]> empty = bfs(i, j, visited, 0, game_board);
                empty = change(empty);
                targetEmpty.add(empty);
            }
        }

        // 테이블의 퍼즐 조각 구하기
        List<List<int[]>> allPuzzles = new ArrayList<>();
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (table[i][j] == 0 || visited[i][j]) continue;

                List<int[]> puzzles = bfs(i, j, visited, 1, table);
                puzzles = change(puzzles);
                allPuzzles.add(puzzles);
            }
        }

        // 퍼즐 사용 여부
        boolean[] used = new boolean[allPuzzles.size()];

        // 빈칸 자리마다
        for (int i = 0; i < targetEmpty.size(); i++) {
            List<int[]> empty = targetEmpty.get(i);

            // 맞는 퍼즐 있는지 확인
            for (int j = 0; j < allPuzzles.size(); j++) {
                if (used[j]) continue; // 이미 쓴 조각이면 스킵

                List<int[]> puzzle = allPuzzles.get(j);

                // 크기 다르면 패스
                if (empty.size() != puzzle.size()) continue;

                // 회전 비교
                boolean foundSame = false; // 현재 빈칸에 맞는 퍼즐 있는지 여부
                for (int r=0; r<4; r++) {
                    boolean isSame = true; // 현재 퍼즐이 빈칸에 맞는지 여부

                    for (int k = 0; k < empty.size(); k++) { // 빈칸 좌표 보면서
                        if (empty.get(k)[0] != puzzle.get(k)[0] || empty.get(k)[1] != puzzle.get(k)[1]) { // 각 좌표가 다르면
                            isSame = false; // 빈칸에 못들어감 -> 회전 다시
                            break;
                        }
                    }

                    if (isSame) { // 빈칸에 들어갈 수 있는 게 있으면 값들 갱신하고 회전 종료
                        used[j] = true; // 현재 퍼즐 사용 처리
                        answer += empty.size(); // 채운 칸 누적
                        foundSame = true;
                        break;
                    }

                    puzzle = rotate(puzzle);
                    puzzle = change(puzzle);
                }

                if (foundSame) break; // 찾은 거 있으면 다음 빈칸으로 넘기기
            }
        }

        return answer;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    private List<int[]> bfs(int x, int y, boolean[][] visited, int value, int[][] board) {
        Queue<int[]> queue = new ArrayDeque<>();

        List<int[]> puzzles = new ArrayList<>();
        puzzles.add(new int[]{x, y});

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d=0; d<4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] != value) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                puzzles.add(new int[]{nx, ny});
            }
        }

        return puzzles;
    }

    // 각 퍼즐을 (0, 0) 기준으로 위치 조정
    private List<int[]> change(List<int[]> puzzles) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] puzzle: puzzles) {
            minX = Math.min(minX, puzzle[0]);
            minY = Math.min(minY, puzzle[1]);
        }


        List<int[]> newPuzzles = new ArrayList<>();
        for (int[] puzzle: puzzles) {
            newPuzzles.add(new int[]{puzzle[0] - minX, puzzle[1] - minY});
        }

        newPuzzles.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        return newPuzzles;
    }

    // 각 퍼즐 90도 회전
    private List<int[]> rotate(List<int[]> puzzles) {
        List<int[]> newPuzzles = new ArrayList<>();
        for (int[] puzzle: puzzles) {
            newPuzzles.add(new int[]{puzzle[1], -puzzle[0]});
        }

        return newPuzzles;
    }
}