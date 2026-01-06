import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// a,b,c리터 물통
// 초기: a,b는 비어있음, c는 가득 참
// 다른 물통으로 부을 수 있음. 이때 한물통이 비거나 다른게 가득 찰때까지 부을 수 있다
// c에 담겨있는 물 양이 변할 수 있다.
// a가 비어있을 때 c에 담겨있을 수 있는 물의 양을 모두 구하기
// 오름차순 정렬

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = new HashSet<>();
        visited = new boolean[A+1][B+1];
        dfs(0, 0, C);

        List<Integer> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        for (int r: resultList) {
            System.out.print(r + " ");
        }
    }

    static int A, B, C;
    static Set<Integer> result;
    static boolean[][] visited;

    public static void dfs(int a, int b, int c) {
        if (visited[a][b]) return;
        visited[a][b] = true;

        if (a == 0) {
            result.add(c);
        }

        int pour;
        if (a != 0) {
            // a->b
            pour = Math.min(a, B-b);
            dfs(a-pour, b+pour, c);

            // a->c
            pour = Math.min(a, C-c);
            dfs(a-pour, b, c+pour);
        }

        if (b != 0) {
            // b->a
            pour = Math.min(b, A-a);
            dfs(a+pour, b-pour, c);

            // b->c
            pour = Math.min(b, C-c);
            dfs(a, b-pour, c+pour);
        }

        if (c != 0) {
            // c->a
            pour = Math.min(c, A-a);
            dfs(a+pour, b, c-pour);

            // c->b
            pour = Math.min(c, B-b);
            dfs(a, b+pour, c-pour);
        }

    }
}