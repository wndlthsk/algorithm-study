import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n개의 수, m개의 구간 i, j 사이 합


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int[] sum = new int[n+1];
        sum[1] = a[1];
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i-1] + a[i];
        }
//        System.out.println(Arrays.toString(sum));

        for (int M = 0; M < m; M++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (i == 1) {
                System.out.println(sum[j]);
            } else {
                System.out.println(sum[j] - sum[i-1]);
            }
        }
    }

}