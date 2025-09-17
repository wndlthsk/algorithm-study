import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// nxm 지도
// r,c : r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수
// 주사위 x, y/ 처음엔 모든 면에 0
// 이동한 칸에 0아닌 수면, 해당 숫자가 주사위 바닥면에 복사되고 칸에 쓰인 수가 0됨
// 주사위가 이동할때마다 상단에 쓰인 값을 구해라

public class Main {
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1: 동, 2: 서, 3: 북, 4: 남
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dx = {0, 0, 0, -1, 1}; // 동, 서, 북, 남
        int[] dy = {0, 1, -1, 0, 0};


        // 1: 위, 2: 뒤, 3: 오른쪽, 4: 왼쪽, 5: 앞, 6: 아래
        dice = new int[7];

        for (int a : arr) {
            int nx = x + dx[a];
            int ny = y + dy[a];

            if (nx >= 0 && nx <n && ny >= 0 && ny <m) {
                x = nx;
                y = ny;
                if (a == 1) {
                    toEast();
                } else if (a == 2) {
                    toWest();
                } else if (a == 3) {
                    toNorth();
                } else if (a == 4) {
                    toSouth();
                }

                if (map[x][y] == 0) {
                    map[x][y] = dice[6];
                } else {
                    dice[6] = map[x][y];
                    map[x][y] = 0;
                }

                System.out.println(dice[1]);
            }
        }
    }


    private static void toEast() {
        int temp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = temp;
    }

    private static void toWest() {
        int temp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = temp;
    }

    private static void toSouth() {
        int temp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = temp;
    }

    private static void toNorth() {
        int temp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = temp;
    }
}