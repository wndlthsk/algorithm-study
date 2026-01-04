import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// n개 물건, 1부터 n까지
// 각 물건에 대해 비교 결과를 알수없는 물건의 개수 출력

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> heavy = new ArrayList<>();
        List<List<Integer>> light = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            heavy.add(new ArrayList<>());
            light.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int heavier = Integer.parseInt(st.nextToken());
            int lighter = Integer.parseInt(st.nextToken());
            light.get(heavier).add(lighter);
            heavy.get(lighter).add(heavier);
        }

        for (int i = 1; i <= n; i++) {
            visitedL = new boolean[n+1];
            visitedL[i] = true;
            int l = dfs(i, light, visitedL);

            visitedH = new boolean[n+1];
            visitedH[i] = true;
            int h = dfs(i, heavy, visitedH);

            System.out.println(n - 1 - (l + h));
        }
    }

    static boolean[] visitedL;
    static boolean[] visitedH;

    public static int dfs(int i, List<List<Integer>> list, boolean[] visited) {
        int count = 0;
        for (int j: list.get(i)) {
            if (!visited[j]) {
                visited[j] = true;
                count++;
                count += dfs(j, list, visited);
            }
        }

        return count;
    }

}