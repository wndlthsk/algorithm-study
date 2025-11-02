// nxm 게임 맵
// 각 칸에 내구도, 공격 받으면 감소, 0이하면 파괴됨/ 아군은 회복 스킬
// 공격, 회복은 항상 직사각형 모양
// board : 건물 내구도
// skill: 적 or 아군 정수 배열 [type, r1, c1, r2, c2, degree]
// type 1(적) / 2(아군)
// (r1, c1)부터 (r2, c2)까지 내구도를 degree 만큼 낮추거나 높인다

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int r = board.length;
        int c = board[0].length;
        int[][] diff = new int[r + 1][c + 1];

        for (int[] sk: skill) {
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];

            if (type == 1) {
                diff[r1][c1] -= degree;
                diff[r1][c2+1] += degree;
                diff[r2+1][c1] += degree;
                diff[r2+1][c2+1] -= degree;
            } else {
                diff[r1][c1] += degree;
                diff[r1][c2+1] -= degree;
                diff[r2+1][c1] -= degree;
                diff[r2+1][c2+1] += degree;
            }


        }

        for (int i=0; i<r+1; i++) {
            for (int j=1; j<c+1; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }

        for (int j=0; j<c+1; j++) {
            for (int i=1; i<r+1; i++) {
                diff[i][j] += diff[i-1][j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}