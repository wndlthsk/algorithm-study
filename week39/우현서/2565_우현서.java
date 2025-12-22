import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 전깃줄 없애서 교차하지 않도록
// 없애야하는 최소 개수


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> wires = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(wires, (a, b) -> a[0]-b[0]);
//        for (int i = 0; i < wires.size(); i++) {
//            System.out.println(wires.get(i)[0] + " " + wires.get(i)[1]);
//        }

        int result = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires.get(j)[1] < wires.get(i)[1]) { // 전깃줄 안겹치면
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        System.out.println(n - result);
    }
}