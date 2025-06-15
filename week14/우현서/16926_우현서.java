import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(a));

        int layers = Math.min(n, m) / 2;

        for (int l = 0; l < layers; l++) {
            List<Integer> temp = new ArrayList<>();
            // 왼쪽 세로줄
            for (int i = l; i < n - l - 1; i++) {
                temp.add(a[i][l]);
            }
            // 아래 가로줄
            for (int j = l; j < m - l - 1; j++) {
                temp.add(a[n - l - 1][j]);
            }
            // 오른쪽 세로줄
            for (int i = n - l - 1; i > l; i--) {
                temp.add(a[i][m - l - 1]);
            }
            // 위 가로줄
            for (int j = m - l - 1; j > l; j--) {
                temp.add(a[l][j]);
            }
//            System.out.println("temp: "+temp);

            //temp를 r만큼 회전
            Collections.rotate(temp, r);
//            System.out.println("after : "+temp);

            // 회전 결과 다시 배열에 넣기
            int idx = 0;
            for (int i = l; i < n - l - 1; i++) {
                a[i][l] = temp.get(idx++);
            }
            // 아래 가로줄
            for (int j = l; j < m - l - 1; j++) {
                a[n - l - 1][j] = temp.get(idx++);
            }
            // 오른쪽 세로줄
            for (int i = n - l - 1; i > l; i--) {
                a[i][m - l - 1] = temp.get(idx++);
            }
            // 위 가로줄
            for (int j = m - l - 1; j > l; j--) {
                a[l][j] = temp.get(idx++);
            }
//            System.out.println("newA: " + Arrays.deepToString(a));
        }

        for(int[] arr: a) {
            for(int i: arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}