class Solution {
    public int[] solution(int n) {
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        int[][] arr = new int[n][n];
        int d = 0;
        int r = -1;
        int c = 0;
        int num = 1;

        for (int len = n; len >= 1; len--) {
            for (int i = 0; i < len; i++) {
                r += dx[d];
                c += dy[d];

                arr[r][c] = num;
                num++;
            }

            d = (d + 1) % 3;
        }

        int size = n * (n + 1) / 2;
        int[] answer = new int[size];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}