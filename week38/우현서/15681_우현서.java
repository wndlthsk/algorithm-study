import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 무방향 트리, 쿼리에 대한 답 출력
// 정정 u를 루트로하는 서브트리에 속한 정점 개수 출력

public class Main {
    static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int r = Integer.parseInt(st.nextToken()); // 루트 번호
        int q = Integer.parseInt(st.nextToken()); // 쿼리 수

        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        counts = new int[n+1];
        dfs(r, -1);
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(counts[u] + "\n");
        }
        System.out.println(sb);
    }

    static int[] counts;

    public static void dfs(int now, int parent) {
        // 자기자신으로 초기값 설정
        counts[now] = 1;

        for (int next : adjList.get(now)) {
            if (next == parent) continue;
            dfs(next, now);
            counts[now] += counts[next];
        }
    }
}