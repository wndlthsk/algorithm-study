// nxn에 사탕 채워 놓는다
// 사탕 색이 다른 인접한 두칸 고름
// 고른 칸에 있는 사탕을 교환
// 모두 같은 색인 가장 긴 연속 부분(행 or 열) 골라서 모두 먹음
// 먹을 수 있는 최대 사탕 수
// c: 빨, p: 파, z: 초, y: 노

// 인접한 색이 다르면 바꿔보고 최대 값 갱신

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
//        System.out.println(Arrays.deepToString(board));

        int result = 0;
        // 오른쪽 검사
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                if (board[i][j] != board[i][j+1]) {
                    swap(i, j, i, j+1);
                    result = Math.max(result, count(n));
                    swap(i, j, i, j+1);
                }
            }
        }

        // 아래 검사
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n; j++) {
                if (board[i][j] != board[i+1][j]) {
                    swap(i, j, i+1, j);
                    result = Math.max(result, count(n));
                    swap(i, j, i+1, j);
                }
            }
        }

        System.out.println(result);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static int count(int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count1 = 1;
            int count2 = 1;

            for (int j = 0; j < n-1; j++) {
                // 행
                if(board[i][j] == board[i][j+1]) count1++;
                else count1 = 1;
                max = Math.max(max, count1);

                // 열
                if (board[j][i] == board[j+1][i]) count2++;
                else count2 = 1;
                max = Math.max(max, count2);
            }
        }

        return max;
    }

}