// 행렬 a, b
// a를 b로 바꾸는데 필요한 최소 연산 횟수
// 3x3의 부분 행렬에 있는 모든 원소를 뒤집는게 연산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = line.charAt(j) - '0';
            }
        }
//        System.out.println(Arrays.deepToString(a));
//        System.out.println(Arrays.deepToString(b));

        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if(a[i][j] != b[i][j]) {
                    flip(i, j); // 왼쪽 위 기준으로 뒤집기
                    count++;
                }
            }
        }
//        System.out.println(Arrays.deepToString(a));

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }

    private static void flip(int i, int j) {
        for (int x = i; x < i+3; x++) {
            for (int y = j; y < j+3; y++) {
                if(a[x][y] == 0) a[x][y] = 1;
                else a[x][y] = 0;
            }
        }
    }

}