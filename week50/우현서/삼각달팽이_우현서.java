class Solution {
    public int[] solution(int n) {
        int[] dx = {1, 0, -1}; // 아래 오른쪽 대각선왼쪽위
        int[] dy = {0, 1, -1};
        int d = 0;
        int num = 1;
        int[][] arr = new int[n][n];

        int x = -1;
        int y = 0;

        int count = 0;
        for (int len = n; len>0; len--) {
            count += len; // 총 숫자 개수

            for (int i=0; i<len; i++) {
                x += dx[d];
                y += dy[d];
                arr[x][y] = num;

                num++;

            }

            d = (d+1)%3;
            // System.out.println(Arrays.deepToString(arr));

        }

        int[] answer = new int[count];
        int idx = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}