import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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
            for (int i=0; i<k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            backtrack(0, 0, new ArrayList<>(), s);
            System.out.println();
        }
    }

    public static void backtrack(int count, int start, List<Integer> now, int[] s) {
        if (count == 6) {
            System.out.println(now.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }
        if (start == s.length) {
            return;
        }

        List<Integer> next = new ArrayList<Integer>(now);
        next.add(s[start]);
        backtrack(count+1, start+1, next, s);
        backtrack(count, start+1, now, s);
    }

}