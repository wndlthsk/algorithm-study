// 대기실 5개,
// 맨해튼 거리 2이하로 앉지 x
// 파티션으로 막혀있으면 가능
// 대기실별 거리두기 지키면 1, 한명이라도 안지키면 0 리턴
// P: 응시자 / 0: 빈테이블 / X: 파티션

// P위치에서 2이하 이내에 또 다른 P가 있으면 실패,
// 걍 구현?


class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int p=0; p<5; p++) {
            char[][] arr = new char[5][5];
            for (int i=0; i<5; i++) {
                arr[i] = places[p][i].toCharArray();
            }

            boolean flag = true;
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    if (arr[i][j] == 'P' && !check(arr, i, j)) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) break;
            }

            answer[p] = flag ? 1 : 0;
        }

        return answer;
    }


    public boolean check(char[][] arr, int i, int j) {
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int d=0; d<4; d++) {
            int ni = i + dx1[d];
            int nj = j + dy1[d];

            if (ni < 0 || ni >= 5 || nj < 0 || nj >= 5) continue;
            if (arr[ni][nj] == 'P') return false;
        }

        int[] dx2 = {-2, 2, 0, 0};
        int[] dy2 = {0, 0, -2, 2};
        for (int d=0; d<4; d++) {
            int ni = i + dx2[d];
            int nj = j + dy2[d];

            if (ni < 0 || ni >= 5 || nj < 0 || nj >= 5) continue;
            if (arr[ni][nj] == 'P' && arr[(i+ni)/2][(j+nj)/2] != 'X') return false;
        }

        int[] dx3 = {-1, -1, 1, 1};
        int[] dy3 = {-1, 1, -1, 1};
        for (int d=0; d<4; d++) {
            int ni = i + dx3[d];
            int nj = j + dy3[d];

            if (ni < 0 || ni >= 5 || nj < 0 || nj >= 5) continue;
            if (arr[ni][nj] == 'P' && (arr[i][nj] != 'X' || arr[ni][j] != 'X')) return false;
        }

        return true;
    }
}