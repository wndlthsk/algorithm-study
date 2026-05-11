// 꺼내야하는 총 상자 개수 리턴

// 1 2 3
// 6 5 4
// 7 8 9
// 121110
// 13


class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int m = (n + w - 1) / w;
        int[][] board = new int[m][w];

        int d = 0;
        int[] dy = {1, -1};

        int r=0;
        int c=0;
        int row = 0;
        int col = 0;

        for (int x=1; x<=n; x++) {
            board[r][c] = x;
            if (x == num) {
                row = r;
                col = c;
            }

            if (x % w == 0) {
                d = (d+1)%2;
                r++;
            } else {
                c = c + dy[d];
            }

        }


        // System.out.println(Arrays.deepToString(board));



        if (board[m-1][col] != 0) {
            answer = m-1 - row + 1;
        } else {
            answer = m-2 - row + 1;
        }

        return answer;
    }
}