// 촌수 계산
// 부모-자식: 1촌,
// 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때 두사람의 촌수를 계산
// 사람들은 1~n 번호, n: 전체 사람 수, m: 부모 자식들 간의 관계의 개수
// x, y: 부모 자식 관계 (x는 y의 부모)
// 각 사람의 부모는 최대 한명
// 두 사람의 촌수 구하기, 계산할 수 없으면 -1 리턴

// 인접리스트로 저장해서(무방향)
// (a, b: 촌수 구해야하는 두사람)
// a에서 시작해서 bfs 돌리면서 촌수 카운트, b가 나오면 촌수 리턴
// 더이상 갈 수 없는데 b가 아니면 -1
// visited 배열 둬서 한번 지나온 사람은 패스하도록

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> relation = new ArrayList<>();
        for(int i=0; i<=n ;i++){
            relation.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation.get(x).add(y);
            relation.get(y).add(x);
        }
//        System.out.println(relation);
        int result = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        queue.add(new int[]{a, 0}); // (현재 사람, 촌수 카운트)
        visited[a] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if (now[0] == b) {
                result = now[1];
                break;
            }
            for (Integer i: relation.get(now[0])){
                if (!visited[i]){
                    queue.add(new int[]{i, now[1] + 1});
                    visited[i] = true;
                }
            }
        }

        System.out.println(result);
    }
}