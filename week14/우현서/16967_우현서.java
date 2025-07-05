// hxw 배열 a와 정수 x, y
// (h+x) x (w+y) 배열 b 는 a와 a를 아래로 x칸,오른쪽으로 y칸 이동시킨 배열을 겹쳐서 만든다.
// 수가 겹쳐지면 더한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w  = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] b = new int[h+x][w+y];
        for (int i=0; i<h+x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<w+y; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] a = new int[h][w];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (i >= x && j >= y) {
                    a[i][j] = b[i][j] - a[i-x][j-y];
                } else {
                    a[i][j] = b[i][j];
                }
            }
        }

        for (int[] k: a) {
            for (int v: k) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }
}