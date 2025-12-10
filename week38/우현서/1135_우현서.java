import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 회사가 트리 구조, 모든 직원은 정확히 한명의 직속 상사
// 모든 직원은 민식이의 직접 또는 간접적 부하다 -> 민식이가 루트?
// 자신의 직속 부하에게만 전화 걸 수 있음. 전화는 1분
// 모든 직원이 소식 듣는데 걸리는 시간의 최솟값 구하기
// 오민식 사원번호: 0

// 자식 많은 자식한테 먼저 전달
// 근데 대기시간도 고려해야함 -> (자식의 서브트리 전파 시간)+(i번째로 전화해서 생기는 지연 시간)

public class Main {
    static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) continue;
            adjList.get(a).add(i);
        }
//        System.out.println(adjList);

        sum = new int[n];
        dfs(0);
//        System.out.println(Arrays.toString(sum));

        System.out.println(sum[0]);
    }

    static int[] sum;

    public static void dfs(int now) {
        List<Integer> childTimes = new ArrayList<>();
        for (int next : adjList.get(now)) {
            dfs(next);
            childTimes.add(sum[next]);
        }
        childTimes.sort(Collections.reverseOrder());

        for (int i=0; i<childTimes.size(); i++) {
            sum[now] = Math.max(sum[now], childTimes.get(i) + (i+1));
        }
    }
}