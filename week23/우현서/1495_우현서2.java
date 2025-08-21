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
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> before = new HashSet<>();
        before.add(s);
        for (int i=0; i<n; i++) {
            Set<Integer> next = new HashSet<>();
            for (Integer b: before) {
                if (b-v[i] >= 0) {
                    next.add(b-v[i]);
                }
                if (b+v[i] <= m) {
                    next.add(b+v[i]);
                }
            }
            before = next;
        }

        if (before.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(Collections.max(before));
        }
    }
}