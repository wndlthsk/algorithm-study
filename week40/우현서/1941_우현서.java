import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 5x5 정사각형 자리 배치
// 이다솜파 -> 소문난 칠공주 결성 규칙
// 7명 여학생
// 7명 자리는 가로/세로 인접해야함
// 이다솜파 학생들로만 구성될 필요는 없다
// 이다솜파가 적어도 4명 이상
// 결성할 수 있는 모든 경우의 수 구하기
// S: 이다솜, Y: 임도연

public class Main {

    static char[][] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        students = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                students[i][j] = s.charAt(j);
            }
        }
//        System.out.println(Arrays.deepToString(students));

        backtrack(0, 0, 0);
        System.out.println(result);
    }


    static int result = 0;
    static boolean[] selected = new boolean[25];

    public static void backtrack(int startIdx, int pickedCount, int sCount) {
        if (pickedCount - sCount >= 4) return;
        if (pickedCount == 7) {
            if (isConnected()) result++;
            return;
        }

        for (int i=startIdx; i<25; i++) {
            selected[i] = true;
            if (students[i/5][i%5] == 'S') backtrack(i+1, pickedCount+1, sCount+1);
            else backtrack(i+1, pickedCount+1, sCount);
            selected[i] = false;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean isConnected() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[25];

        for(int i=0; i<25; i++) {
            if (selected[i]) {
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        int count = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            int r = now / 5;
            int c = now % 5;

            for (int d=0; d<4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

                int next = nr * 5 + nc;
                if (!selected[next]) continue;
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                count++;
            }
        }

        return count == 7;
    }
}