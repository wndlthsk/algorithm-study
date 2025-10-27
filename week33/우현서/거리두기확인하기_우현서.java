// 대기실 5개, 5x5
// 맨해튼 거리 2이하로 앉지 않는다
// 파티션으로 막힌 경우 허용
// P: 응시자가 앉아있는 자리 / 0: 빈 테이블 / X: 파티션
// places: 응시자들 정보 & 대기실 구조
// 대기실별 거리두기 지키면 1, 아니면 0 리턴

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();

        for (int room=0; room<5; room++) {
            char[][] place = new char[5][5];
            for (int i = 0; i < 5; i++) {
                place[i] = places[room][i].toCharArray();
            }
            // System.out.println(Arrays.deepToString(place));

            boolean isSafe = true;

            // 모든 좌석 탐색
            for (int i = 0; i < 5 && isSafe; i++) {
                for (int j = 0; j < 5 && isSafe; j++) {
                    if (place[i][j] == 'P') {
                        if (!bfs(place, i, j)) { // 한 명 기준으로 BFS
                            isSafe = false;
                        }
                    }
                }
            }

            answer.add(isSafe ? 1 : 0);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public boolean bfs(char[][] place, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new int[]{i, j, 0}); // x, y, dist
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
                if (place[nx][ny] == 'X') continue;
                if (place[nx][ny] == 'P' && dist + 1 <= 2) return false;

                if (place[nx][ny] == 'O') {
                    queue.add(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return true;
    }
}