// 가로, 세로, 대각선 경로에 있으면 공격할 수 있음
// 서로 공격할 수 없게 배치하는 방법의 수

class Solution {
    public int solution(int n) {
        cols = new boolean[n];
        diagonal1 = new boolean[2*n]; // 오른쪽 아래로
        diagonal2 = new boolean[2*n]; // 오른쪽 위로

        backtrack(0, n);
        // System.out.println(count);

        return count;
    }

    boolean[] cols;
    boolean[] diagonal1;
    boolean[] diagonal2;


    int count = 0;
    public void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col=0; col<n; col++) {
            if (cols[col] || diagonal1[col-row+n] || diagonal2[col+row]) continue;
            cols[col] = true;
            diagonal1[col-row+n] = true;
            diagonal2[col+row] = true;

            backtrack(row+1, n);

            cols[col] = false;
            diagonal1[col-row+n] = false;
            diagonal2[col+row] = false;
        }
    }
}