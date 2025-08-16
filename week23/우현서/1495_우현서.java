import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 곡 개수
        int s = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int m = Integer.parseInt(st.nextToken()); // 최대 볼륨
        int[] v = new int[n+1];
        v[0] = s;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(v));

        Set<Integer> before = new HashSet<Integer>();
        before.add(s);
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (Integer b : before) {
                if (b - v[i] >= 0) {
                    set.add(b - v[i]);
                }
                if (b + v[i] <= m) {
                    set.add(b + v[i]);
                }
            }
            before = set;
        }
        if (before.isEmpty()) {
            System.out.println("-1");
        }
        else {
            System.out.println(Collections.max(before));
        }
    }
}