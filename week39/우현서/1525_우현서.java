import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 3x3 오른쪽 아래 끝칸은 비어있음
// 인접 4칸중 하나가 비어있으면 수를 그 칸으로 이동시킬 수 있음
// 최소의 이동으로 순서대로 정리된 상태 만들기
// 최소이동횟수 출력, 불가능하면 -1

class Puzzle {
    String nums;
    int count;

    public Puzzle(String nums, int count) {
        this.nums = nums;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][3];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                sb.append(st.nextToken());
            }
        }

        int result = bfs(sb.toString());
        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(String start) {
        Queue<Puzzle> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Puzzle(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Puzzle now = queue.poll();
            String nowNums = now.nums;
            int nowCount = now.count;

            if (nowNums.equals("123456780")) {
                return nowCount;
            }

            int zeroIdx = -1;
            for (int i=0; i<nowNums.length(); i++) {
                if (nowNums.charAt(i) == '0') {
                    zeroIdx = i;
                    break;
                }
            }
            int x = zeroIdx / 3;
            int y = zeroIdx % 3;

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nZeroIdx = nx * 3 + ny;

                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
                String newStr = swap(nowNums, zeroIdx, nZeroIdx);
                if (visited.contains(newStr)) continue;
                visited.add(newStr);
                queue.add(new Puzzle(newStr, nowCount + 1));
            }
        }

        return -1;
    }

    public static String swap(String now, int before, int after) {
        char[] chars = now.toCharArray();
        char temp = chars[before];
        chars[before] = chars[after];
        chars[after] = temp;

        return new String(chars);
    }
}