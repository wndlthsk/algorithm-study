import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// n개 마을, 1~n번
// 나라가 트리 구조, n-1개 길, 양방향
// 모든 마을은 연결돼있음. 두마을 사이 직접 잇는 길이 있으면 인접한 마을
// 우수 마을 조건
// 1. 우수마을들의 주민 수 총합 최대
// 2. 우수마을끼리는 인접할 수 x
// 3. 우수마을 아닌 마을은 적어도 하나의 우수마을과 인접해야한다
// 우수마을의 주민수의 총합 출력

// 현재 마을을 우수로 뽑거나 말거나
// 한 노드당 2가지 선택 상태가 있다.
// 근데 부모가 우수 마을이면, 자식은 우수 아니어야한다.
// 현재 노드를 선택하거나 말거나 했을 때 자식들의 최적값을 구하자
// 하위 문제들의 최적값(자식들) 을 모아 현재문제의 최적값(현재 노드)을 만든다 -> dp다!
// dfs돌면서 부모/자식이 결정된다(트리는 사이클이 없기때문), 루트를 1로 두자
// dp[i][0]: i를 우수로 안 뽑았을때 최대 주민수, dp[i][1]: i를 뽑았을 때 최대 주민수

public class Main {
    static int[] people;
    static List<List<Integer>> adjTown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[n+1];
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        adjTown = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjTown.add(new ArrayList<>());
        }
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjTown.get(a).add(b);
            adjTown.get(b).add(a);
        }
//        System.out.println(adjTown);

        dp = new int[n+1][2];
        dfs(1, -1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static int[][] dp;

    public static void dfs(int now, int parent) {
        // 현재마을 선택하면 주민 수로 초기값 설정
        dp[now][1] = people[now];

        for (int next : adjTown.get(now)) {
            if (parent == next) continue;
            dfs(next, now);
            // 선택 안하면 자식의 선택/안함 중에 큰 값 더하기
            dp[now][0] += Math.max(dp[next][0], dp[next][1]);
            // 선택하면 자식은 선택 x
            dp[now][1] += dp[next][0];
        }
    }
}