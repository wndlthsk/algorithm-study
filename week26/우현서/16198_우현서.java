import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            weights.add(Integer.parseInt(st.nextToken()));
        }

        backtrack(weights, 0);
        System.out.println(result);
    }

    static int result = 0;

    public static void backtrack(List<Integer> now, int sum) {
        if (now.size() == 2) {
            result = Math.max(result, sum);
        }

        for (int i = 1; i <= now.size()-2; i++) {
            int energy = now.get(i-1) * now.get(i+1);
            int removed = now.remove(i);
            backtrack(now, sum+energy);
            now.add(i, removed);
        }
    }

}