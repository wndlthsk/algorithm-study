// 가장 유명한 사람: 2-친구가 가장 많은 사람
// a가 b의 2-친구가 되려면, 두 사람이 친구이거나, a와 치구이고 b와 친구인 c가 있어야함

// 인접리스트로 변환한 후, 각 사람에 대해 bfs를 돌린다. 이때 관계의 깊이가 2단계까지만 돌게
// 시간 복잡도: O(n^2), n<=50

// bfs 안돌리고 2중 for문으로 확인해도 된다. 하지만 단계수가 많아지면 안됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friends.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'Y') {
                    friends.get(i).add(j);
                }
            }
        }
//        System.out.println(friends);

        int result = 0;
        for (int i = 0; i < n; i++) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            queue.offer(new int[]{i, 0}); // 사람, 깊이
            visited[i] = true;
            int count = 0;
            while(!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[1] == 2) continue; // 2단계만 가능
                for (int next : friends.get(now[0])) {
                    if (!visited[next]) {
                        count++;
                        queue.offer(new int[]{next, now[1]+1});
                        visited[next] = true;
                    }
                }
            }
            result = Math.max(result, count);
        }

//        2중 for문으로 구현
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            boolean[] known = new boolean[n];
//            for (int friend : friends.get(i)) {
//                known[friend] = true; // 1단계 친구
//                for (int ff : friends.get(friend)) {
//                    known[ff] = true; // 2단계 친구
//                }
//            }
//            known[i] = false; // 자기 자신 제외
//            int count = 0;
//            for (boolean b : known) {
//                if (b) count++;
//            }
//            result = Math.max(result, count);
//        }

        System.out.println(result);
    }

}