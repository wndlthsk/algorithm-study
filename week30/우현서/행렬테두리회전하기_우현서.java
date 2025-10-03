// r*c 행렬, 1부터 r*c까지 숫자가 한줄씩 순서대로
// 직사각형 모양 범위 여러번 선택, 테두리 숫자를 시계방향 회전
// (x1, y1, x2, y2) : x1 행 y1 열부터 x2 행 y2 열까지의 영역
// 회전으로 바뀐 숫자의 최솟값을 순서대로 리턴

class Solution {
    int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows][columns];
        int num = 1;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                board[i][j] = num;
                num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int[] q = queries[i];
            int min = rotate(q[0]-1, q[1]-1, q[2]-1, q[3]-1);
            answer[i] = min;
        }

        return answer;
    }


    public int rotate(int x1, int y1, int x2, int y2) {
        int min = 10001;

        int temp = board[x1][y1];
        for (int x=x1; x<x2; x++) {
            board[x][y1] = board[x+1][y1];
            min = Math.min(min, board[x+1][y1]);
        }
        for (int y=y1; y<y2; y++) {
            board[x2][y] = board[x2][y+1];
            min = Math.min(min, board[x2][y+1]);
        }
        for (int x=x2; x>x1; x--) {
            board[x][y2] = board[x-1][y2];
            min = Math.min(min, board[x-1][y2]);
        }
        for (int y=y2; y>y1+1; y--) {
            board[x1][y] = board[x1][y-1];
            min = Math.min(min, board[x1][y-1]);
        }
        board[x1][y1+1] = temp;
        min = Math.min(min, temp);

        return min;
    }
}