import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a;
    static int[] operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(1, a[0]);
        System.out.println(max);
        System.out.println(min);

    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void backtrack(int count, int result) {
        if (count == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if (i == 0) backtrack(count+1, result + a[count]);
                else if (i == 1) backtrack(count+1, result - a[count]);
                else if (i == 2) backtrack(count+1, result * a[count]);
                else backtrack(count+1, result / a[count]);
                operators[i]++;
            }
        }
    }
}