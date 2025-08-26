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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] board = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }
//        System.out.println(Arrays.toString(board));

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        queue.add(new int[]{1, 0}); // 현재 위치, 주사위 카운트
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int count = now[1];

            if (x == 100) {
                System.out.println(count);
            }

            for (int i=1; i<=6; i++) {
                int nx = x+i;
                if (nx <= 100) {
                    if (board[nx] > 0) {
                        nx = board[nx];
                    }
                    if (!visited[nx]) {
                        visited[nx] = true;
                        queue.add(new int[]{nx, count+1});
                    }
                }

            }
        }

    }


    // 고정 배열 안쓰고
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        Map<Integer, Integer> board = new HashMap<>();
//        for (int i = 0; i < n+m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            board.put(a, b);
//        }
////        System.out.println(Arrays.toString(board));
//
//        Queue<int[]> queue = new ArrayDeque<>();
//        Set<Integer> visited = new HashSet<>();
//        queue.add(new int[]{1, 0}); // 현재 위치, 주사위 카운트
//        visited.add(1);
//
//        while (!queue.isEmpty()) {
//            int[] now = queue.poll();
//            int x = now[0];
//            int count = now[1];
//
//            if (x == 100) {
//                System.out.println(count);
//                break;
//            }
//
//            for (int i=1; i<=6; i++) {
//                int nx = x+i;
//                if (nx <= 100) {
//                    if (board.containsKey(nx)) {
//                        nx = board.get(nx);
//                    }
//                    if (!visited.contains(nx)) {
//                        visited.add(nx);
//                        queue.add(new int[]{nx, count+1});
//                    }
//                }
//
//            }
//        }
//
//    }

}