// 돌은 세개 그룹으로 나눠져있고, 각 그룹에는 돌이 a,b,c개 있다.
// 모든 그룹의 돌 개수를 같게 만들려고 한다.
// 돌을 단계별로 움직인다.
// 크기가 다른 두 그룹을 고른다.
// 개수가 작은쪽 x, 큰 쪽 y
// x에 있는 돌개수 -> x+x / y에 있는 돌 개수 -> y-x
// a,b,c가 주어질때 돌을 같은 개수로 만들 수 있으면 1, 아니면 0을 출력

// (a,b) (a,c) (b,c)
// 돌을 움직이는 과정이 여러번 반복 가능한 거다.
// 가능한 모든 상태를 탐색해야한다.
// 이때 같은 상태를 반복하지 않도록 방문처리를 해야한다.
// 각 그룹의 돌 개수는 0부터 a+b+c까지 정해져있다. -> bfs를 사용해 중복없이 탐색
// 큐에 (a,b,c)가 아니라 (a,b)만 저장한다. 왜냐면 c는 sum-a-b로 계산할 수 있기 때문이다.
// visited도 마찬가지로 boolean[][]로 둔다.
// 탐색은 큐에 (a,b) 넣고 방문 처리로 시작한다.
// 큐에서 현재 상태를 꺼내고 c의 개수도 계산해서 배열로 둔다 (rock)
// 배열의 세 원소가 모두 같은 값이면 1 출력 후 종료
// 아니면 (a,b) (a,c) (b,c)에 대해 탐색한다.
// 그룹 2개의 크기를 비교해서 다음 상태를 계산후 방문한 적이 없다면 큐에 넣는다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = a + b + c; // 각 그룹의 돌 개수 : 0~sum개이므로 visited를 sum+1까지 해야함

        Queue<int[]> queue = new ArrayDeque<>(); // a의 돌 개수, b의 돌 개수
        boolean[][] visited = new boolean[sum+1][sum+1];
        queue.add(new int[]{a, b});
        visited[a][b] = true;

        // 그룹 인덱스
        int[] dx = {0, 0, 1}; // a, a, b
        int[] dy = {1, 2, 2}; // b, c, c

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int[] rock = {now[0], now[1], sum - now[0] - now[1]};

            if (rock[0] == rock[1] && rock[1] == rock[2]) {
                System.out.println("1");
                return;
            }

            for (int d=0; d<3; d++) {
                int group1 = rock[dx[d]];
                int group2 = rock[dy[d]];

                if (group1 < group2) {
                    int newSmall = group1 + group1;
                    int newBig = group2 - group1;
                    if (!visited[newSmall][newBig]) {
                        visited[newSmall][newBig] = true;
                        queue.add(new int[]{newSmall, newBig});
                    }
                } else if (group1 > group2) {
                    int newSmall = group2 + group2;
                    int newBig = group1 - group2;
                    if (!visited[newSmall][newBig]) {
                        visited[newSmall][newBig] = true;
                        queue.add(new int[]{newSmall, newBig});
                    }
                }
            }
        }
        System.out.println("0");
    }

}