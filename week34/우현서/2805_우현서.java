import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 M 미터가 필요함
// 목재절단기 동작
// 높이 h 정하면 톱날이 h미터 올라감
// 한줄에 연속해있는 나무를 모두 절단
// 높이 h보다 큰 나무들은 h윗부분이 잘리고, 낮으면 안 잘림
// 잘린부분을 들고 간다.
// 적어도 M미터 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값 구하기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
//        System.out.println(Arrays.toString(trees));

        int s = 1;
        int e = trees[n-1];
        int result = 0;
        int mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
//            System.out.println("s: " + s + ", e: " + e + ", mid: " + mid);

            long sum = 0;
            for (int i=n-1; i>=0; i--) {
                if (trees[i] <= mid) break;
                sum += trees[i] - mid;
//                System.out.println("sum: " + sum);
            }

            // 찾음
            if (sum == m) {
                System.out.println(mid);
                return;
            }

            if (sum > m) {
                result = mid;
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        System.out.println(result);
    }
}