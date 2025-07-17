// 주사위 1~6, 10*10 보드판, 보드판에는 1~100까지
// 주사위 굴린만큼 이동해야한다. ex) i에서 i+숫자 칸으로 이동
// 뱀 있는 칸 -> 숫자 작아짐 / 사다리 칸 -> 숫자 커짐
// 목표는 1번 칸에서 100번 칸에 도착하는 것이다 --> 1based
// 주사위 굴리는 최소 횟수 구하기

// n: 사다리 수, m: 뱀 수
// n줄 사다리 정보 -> (x,y) : x도착시 y칸으로 이동
// m줄 뱀 정보 -> (u,v) : u도착시 v칸으로 이동

// 1칸부터 6칸 이동을 방향이라고 생각하면 bfs로 구현할 수 있다. + 최소횟수니까

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] board = new int[101];
        Arrays.fill(board, -1);

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
//        System.out.println(Arrays.toString(board));

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        queue.add(new int[]{1, 0}); // 현재 위치, 굴린횟수
        visited[1] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = now[0];
            int count = now[1];

            if (num == 100) {
                System.out.println(count);
                break;
            }

            for (int i=1; i<=6; i++) {
                int next = num + i;
                if (next <= 100 && !visited[next]) {
                    visited[next] = true;
                    int realNext = next;
                    if (board[next] != -1) { // 사다리/뱀이면 next갱신
                        realNext = board[next];
                    }
                    queue.add(new int[]{realNext, count+1});
                }
            }
        }
    }
}

