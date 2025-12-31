import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n개의 정수 배열 a
// 정수 순서를 바꿔 최댓값 구하기

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        output = new int[n];
        permutation(a, n, n, 0);
        System.out.println(max);
    }

    static int[] output;
    static boolean[] visited;
    static int max = 0;

    public static void permutation(int[] arr, int n, int r, int depth) {
        if (depth == r) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += Math.abs(output[i-1] - output[i]);
            }
            max = Math.max(max, sum);

            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, n, r, depth+1);
                visited[i] = false;
            }
        }
    }

}