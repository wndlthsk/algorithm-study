// nxm 게임 맵, 내구도
// 공격 받으면 내구도 감소, 0 이하되면 파괴
// 아군 회복 스킬로 높ㅇ리ㅕ함
// 0이하 상태여도 계속 하락/상승할 수 있음

// board: 건물 내구도
// skill: 적군 아군 스킬
// [type, r1, c1, r2, c2, degree]
// type 1(적군) / 2(아군)

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        int[][] diff = new int[n+1][m+1];
        for (int[] s: skill) {
            if (s[0] == 1) {
                diff[s[1]][s[2]] -= s[5];
                diff[s[1]][s[4]+1] += s[5];
                diff[s[3]+1][s[2]] += s[5];
                diff[s[3]+1][s[4]+1] -= s[5];
            } else {
                diff[s[1]][s[2]] += s[5];
                diff[s[1]][s[4]+1] -= s[5];
                diff[s[3]+1][s[2]] -= s[5];
                diff[s[3]+1][s[4]+1] += s[5];
            }
        }

        for (int i=0; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }

        for (int j=0; j<m+1; j++) {
            for (int i=1; i<n+1; i++) {
                diff[i][j] += diff[i-1][j];
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] + diff[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}