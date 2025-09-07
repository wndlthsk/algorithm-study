import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] A = new int[r+1][c+1];
        int[] cleaner = new int[2];
        int idx = 0;
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                int temp = Integer.parseInt(st.nextToken());
                A[i][j] = temp;
                if (temp == -1) {
                    cleaner[idx] = i;
                    idx++;
                }
            }
        }
//        System.out.println(Arrays.toString(cleaner));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int T = 0; T < t; T++) {
            // 확산
            int[][] spread = new int[r + 1][c + 1];
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    if (A[i][j] > 0) {
                        int spreadAmount = A[i][j] / 5;
                        int cnt = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if (ni > 0 && ni <= r && nj > 0 && nj <= c) {
                                if (A[ni][nj] != -1) {
                                    spread[ni][nj] += spreadAmount;
                                    cnt++;
                                }
                            }
                        }
                        spread[i][j] -= spreadAmount * cnt;
                    }
                }
            }

            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    A[i][j] += spread[i][j];
                }
            }

            // 순환
            // 윗부분
            int top = cleaner[0];
            for (int x = top - 1; x > 1; x--) {
                A[x][1] = A[x - 1][1];
            }
            for (int y = 1; y < c; y++) {
                A[1][y] = A[1][y + 1];
            }
            for (int x = 1; x < top; x++) {
                A[x][c] = A[x + 1][c];
            }
            for (int y = c; y > 2; y--) {
                A[top][y] = A[top][y - 1];
            }
            A[top][2] = 0;

            // 아랫부분
            int bottom = cleaner[1];
            for (int x = bottom + 1; x < r; x++) {
                A[x][1] = A[x + 1][1];
            }
            for (int y = 1; y < c; y++) {
                A[r][y] = A[r][y + 1];
            }
            for (int x = r; x > bottom; x--) {
                A[x][c] = A[x - 1][c];
            }
            for (int y = c; y > 2; y--) {
                A[bottom][y] = A[bottom][y - 1];
            }
            A[bottom][2] = 0;
        }

        int result = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (A[i][j] == -1) continue;
                result += A[i][j];
            }
        }

        System.out.println(result);


    }
}