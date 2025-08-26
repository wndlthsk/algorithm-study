import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            int[] s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            backtrack(0, 0, new ArrayList<>(), s);
            System.out.println();
        }
    }

    public static void backtrack(int count, int start, List<Integer> now, int[] s) {
        if (count == 6) {
            for (int num : now) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        if (start == s.length) {
            return;
        }

        now.add(s[start]);
        backtrack(count + 1, start+1, now, s);
        now.remove(now.size() - 1);
        backtrack(count, start+1, now, s);
    }

}