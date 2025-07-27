// 연구소 nxm, 0: 빈칸/ 1: 벽/ 2: 바이러스
// 일부 칸 바이러스, 바이러스는 4방향으로 퍼짐
// 새로 벽 3개 세우기
// 바이러스가 퍼질 수 없는 곳: 안전영역
// 안전영역 크기의 최댓값 구하기

// 벽 세울 3칸을 선택(조합) -> 바이러스 퍼지고 안전영역 계산
// 3칸 선택은 백트래킹, 바이러스 퍼지는 건 bfs로 처리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Main {
    static List<Node> empty;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        empty = new ArrayList<>();
        List<Node> virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp == 0) {
                    empty.add(new Node(i, j));
                } else if (temp == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        List<List<Node>> combis = new ArrayList<>();
        combination(new ArrayList<>(), 0, 3, combis);
//        System.out.println(combis);

        int result = 0;
        for (List<Node> node : combis) {
            int[][] copiedMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copiedMap[i][j] = map[i][j];
                }
            }

            // 벽 3개를 세운다
            for (Node no: node) {
                copiedMap[no.x][no.y] = 1;
            }

            // 바이러스가 퍼진다
            bfs(virus, copiedMap);
//            System.out.println(Arrays.deepToString(copiedMap));

            // 안전영역 카운트
            int count = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(copiedMap[i][j]==0) {
                        count++;
                    }
                }
            }

            result = Math.max(result, count);

        }

        System.out.println(result);
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void bfs(List<Node> virus, int[][] map) {
        Queue<Node> q = new ArrayDeque<>(virus);

        while(!q.isEmpty()) {
            Node now = q.poll();

            for (int d = 0; d < 4; d++) {
                int x = now.x + dx[d];
                int y = now.y + dy[d];
                if (x>=0 && x<n && y>=0 && y<m) {
                    if (map[x][y] == 0) {
                        map[x][y] = 2;
                        q.add(new Node(x, y));
                    }
                }
            }
        }
    }

    public static void combination(List<Node> nums, int start, int r, List<List<Node>> result) {
        if (nums.size() == r) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            nums.add(empty.get(i));
            combination(nums, i + 1, r, result);
            nums.remove(nums.size() - 1);
        }
    }
}