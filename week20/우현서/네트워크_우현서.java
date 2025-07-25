// a-b, b-c -> a,b,c 모두 같은 네트워크
// n: 컴퓨터 개수, computers: 연결 정보
// 네트워크 개수 리턴

// bfs 돌면서 카운트한다.

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 인접리스트로 변환
        List<List<Integer>> coms = new ArrayList<>();
        for(int i=0;i<n;i++){
            coms.add(new ArrayList<>());
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (computers[i][j] == 1) {
                    coms.get(i).add(j);
                }
            }
        }
        // System.out.println(coms);

        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                bfs(i, visited, coms);
                answer++;
            }
        }


        return answer;
    }

    public void bfs (int start, boolean[] visited, List<List<Integer>> coms) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: coms.get(now)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}