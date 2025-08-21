import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr));

        backtrack(0, 0, n, s, arr);
        if(s==0) result--;

        System.out.println(result);
    }

    static int result = 0;
    public static void backtrack(int i, int sum, int n, int s, int[] arr) {
        if (i == n) {
            if (sum == s) {
                result++;
            }
            return;
        }

        backtrack(i+1, sum, n, s, arr);
        backtrack(i+1, sum + arr[i], n, s, arr);
    }
}