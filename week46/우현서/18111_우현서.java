import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// (i, j) 가장 위 블록을 제거후 인벤토리 -> 2초
// 인벤토리에서 꺼내서 (i, j) 위에 둔다 -> 1초
// 땅고르기 작업의 최소시간과 높이 출력
// 여러개면 땅 높이가 가장 높은 것

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(board));


        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int target = 256; target >= 0; target--) {
            int inventory = b;
            int time = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (board[i][j] < target) {
                        int k = target - board[i][j];
                        time += k;
                        inventory -= k;
                    } else if (board[i][j] > target) {
                        int k = board[i][j] - target;
                        time += 2*k;
                        inventory += k;
                    }
                }
            }

            if (inventory >= 0 && time < minTime) {
                minTime = time;
                height = target;
            }
        }

        System.out.println(minTime + " " + height);
    }

}