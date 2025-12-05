import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// nxm 직사각형에 수 써놓음
// 겹치지 않는 3개로 나누려고 함
// 각 칸은 하나의 직사각형에만 포함돼야하고 각 직사각형은 적어도 하나의 숫자를 포함해야함
// 작은 직사각형의 합 = 수의 합
// 각 작의 직사각형의 합의 곱을 최댓값 출력

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        arr = new int[n][m];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
//        for (int[] ints : arr) {
//            System.out.println(Arrays.toString(ints));
//        }

        long result = 0;

        // 세로 3등분
        if (n == 1) {
            result = Math.max(result, seroEqual(n, m));
            System.out.println(result);
            return;
        }
        // 가로 3등분
        if (m == 1) {
            result = Math.max(result, garoEqual(n, m));
            System.out.println(result);
            return;
        }

        // 세로 3등분 or 세+왼가 or 세+오른가
        // 가로 3등분 or 가+위세 or 가+아래세
        result = Math.max(result, seroEqual(n, m));
        result = Math.max(result, seroLeftGaro(n, m));
        result = Math.max(result, seroRightGaro(n, m));
        result = Math.max(result, garoEqual(n, m));
        result = Math.max(result, garoUpSero(n, m));
        result = Math.max(result, garoDownSero(n, m));
        System.out.println(result);

    }

    public static long seroEqual(int n, int m) {
        long max = 0;
        long sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i=1; i<=m-2; i++) {
            for (int j=i+1; j<=m-1; j++) {
                sum1 = sum(0, 0, n-1, i-1);
                sum2 = sum(0, i, n-1, j-1);
                sum3 = sum(0, j, n-1, m-1);
                max = Math.max(max, sum1 * sum2 * sum3);
            }
        }

        return max;
    }

    public static long garoEqual(int n, int m) {
        long max = 0;
        long sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                sum1 = sum(0, 0, i - 1, m - 1);
                sum2 = sum(i, 0, j-1, m - 1);
                sum3 = sum(j, 0, n-1, m - 1);
                max = Math.max(max, sum1 * sum2 * sum3);
            }
        }

        return max;
    }

    public static long seroLeftGaro(int n, int m) {
        long max = 0;
        long sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i=1; i<=m-1; i++) {
            for (int j=1; j<=n-1; j++) {
                sum1 = sum(0, 0, j-1, i-1);
                sum2 = sum(j, 0, n-1, i-1);
                sum3 = sum(0, i, n-1, m-1);
                max = Math.max(max, sum1 * sum2 * sum3);
            }
        }

        return max;
    }

    public static long seroRightGaro(int n, int m) {
        long max = 0;
        long sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i=1; i<=m-1; i++) {
            for (int j=1; j<=n-1; j++) {
                sum1 = sum(0, 0, n-1, i-1);
                sum2 = sum(0, i, j-1,  m-1);
                sum3 = sum(j, i, n-1, m-1);
                max = Math.max(max, sum1 * sum2 * sum3);
            }
        }

        return max;
    }

    public static long garoUpSero(int n, int m) {
        long max = 0;
        long sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=m-1; j++) {
                sum1 = sum(0, 0, i-1, j-1);
                sum2 = sum(0, j, i-1,  m-1);
                sum3 = sum(i, 0, n-1, m-1);
                max = Math.max(max, sum1 * sum2 * sum3);
            }
        }

        return max;
    }

    public static long garoDownSero(int n, int m) {
        long max = 0;
        long sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=m-1; j++) {
                sum1 = sum(0, 0, i-1, m-1);
                sum2 = sum(i, 0, n-1,  j-1);
                sum3 = sum(i, j, n-1, m-1);
                max = Math.max(max, sum1 * sum2 * sum3);
            }
        }

        return max;
    }


    public static long sum(int a, int b, int c, int d) {
        long sum = 0;
        for (int i=a; i<=c; i++) {
            for (int j=b; j<=d; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}