import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 수빈 뮤탈리스크1개, 강호 scv n개 남음
// 뮤탈리스크가 공격할때 한번에 3개의 scv공격 가능
// 첫번째 공격 받은 scv 체력 -9
// 두번째 -3
// 세번째 -1
// scv의 체력이 0이하가 되면즉시 파괴됨
// 모든 scv를 파괴하기 위해 필요한 최소 공격횟수

class State {
    int a;
    int b;
    int c;
    int count;

    public State(int a, int b, int c, int count) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scvs = new int[3];
        for (int i = 0; i < n; i++) {
            scvs[i] = Integer.parseInt(st.nextToken());
        }

        int[][] attacks = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
        };

        Arrays.sort(scvs);

        Queue<State> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[61][61][61];
        queue.add(new State(scvs[0], scvs[1], scvs[2], 0));
        visited[scvs[0]][scvs[1]][scvs[2]] = true;

        while (!queue.isEmpty()) {
            State now = queue.poll();
            int a = now.a;
            int b = now.b;
            int c = now.c;
            int count = now.count;

            if (a == 0 && b == 0 && c == 0) {
                System.out.println(count);
                return;
            }

            for (int[] attack: attacks) {
                int na = Math.max(0, a - attack[0]);
                int nb = Math.max(0, b - attack[1]);
                int nc = Math.max(0, c - attack[2]);
                int[] nscvs = new int[]{na, nb, nc};
                Arrays.sort(nscvs);

                if (visited[nscvs[0]][nscvs[1]][nscvs[2]]) continue;
                visited[nscvs[0]][nscvs[1]][nscvs[2]] = true;
                queue.add(new State(nscvs[0], nscvs[1], nscvs[2], count+1));
            }
        }
    }
}