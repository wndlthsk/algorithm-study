// 알파벳 1번 -> 4면중 적어도 1면이 외부와 연결된 컨테이너만 꺼내기
// 같은 알파벳 2번 반복 -> 해당 알파벳 모든 컨테이너 꺼내기
// 모든 요청 완료후 남은 컨테이너 수 구하기

// 지게차 조건에 맞는 걸 저장하면서 구하기?

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    char[][] storages;

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        storages = new char[n+2][m+2];

        // 외곽 표시
        for (int i=0; i<=n+1; i++) {
            storages[i][0] = '#';
            storages[i][m+1] = '#';
        }
        for (int i=0; i<=m+1; i++) {
            storages[0][i] = '#';
            storages[n+1][i] = '#';
        }

        // 배열로 변경
        for (int i=0; i<n; i++) {
            int j=1;
            for (char c: storage[i].toCharArray()) {
                storages[i+1][j] = c;
                j++;
            }
        }

        // 요청 처리
        for (String request: requests) {
            // 외곽 여부 bfs로 확장
            expandOutside(n, m);

            char c = request.charAt(0);

            if (request.length() == 1) { // 하나 요청
                List<int[]> candidates = new ArrayList<>();
                for (int i=1; i<n+1; i++) {
                    for (int j=1; j<m+1; j++) {
                        if (storages[i][j] == c && isPossible(i, j)) candidates.add(new int[]{i, j});
                    }
                }

                for (int[] can: candidates) {
                    storages[can[0]][can[1]] = '#';
                }

            } else { // 두개 요청
                for (int i=1; i<n+1; i++) {
                    for (int j=1; j<m+1; j++) {
                        if (storages[i][j] == c) storages[i][j] = '#';
                    }
                }
            }

        }



        int answer = 0;

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (storages[i][j] != '#') answer++;
            }
        }

        return answer;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public boolean isPossible(int i, int j) {
        for (int d=0; d<4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];

            if (outside[ni][nj]) return true;
        }

        return false;
    }


    boolean[][] outside;

    public void expandOutside(int n, int m) { // (0,0)부터 접근할 수 있는 #표시 부분을 outside에 체크
        outside = new boolean[n+2][m+2];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        outside[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d=0; d<4; d++) {
                int ni = now[0] + dx[d];
                int nj = now[1] + dy[d];

                if (ni<0 || nj<0 || ni>=n+2 || nj>=m+2) continue;
                if (outside[ni][nj]) continue;

                if (storages[ni][nj] == '#') {
                    outside[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }
        }

    }

}