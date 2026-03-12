// 같은 좌표에 2대 이상 모이면 위험 상황으로 판단
// 위험 상황이 총 몇번 일어나는지 구하기

// points: 운송 포인트 좌표 [r, c]
// routes: 로봇 운송 경로

// 각 지점에서 bfs, 같은 좌표에 만나는 거 개수 카운팅
// 경로가 필요하니까 dfs? 근데 최단 거리 보장안하잖아

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] points, int[][] routes) {

        int robots = routes.length;

        Map<String, Integer> countMap = new HashMap<>(); // (시간_x_y, 개수)

        for (int i=0; i<robots; i++) {
            int[] r = routes[i];
            int time = 0;

            // 시작점 넣기
            int start = r[0];
            int x = points[start-1][0];
            int y = points[start-1][1];

            String str = time + "_" + x + "_" + y;
            countMap.put(str, countMap.getOrDefault(str, 0)+1);


            for (int j=1; j<r.length; j++) {
                int to = r[j];

                int tx = points[to-1][0];
                int ty = points[to-1][1];

                // r 먼저 이동
                while (x != tx) {
                    if (x < tx) x++;
                    else x--;

                    time++;
                    str = time + "_" + x + "_" + y;
                    countMap.put(str, countMap.getOrDefault(str, 0)+1);
                }

                while (y != ty) {
                    if (y < ty) y++;
                    else y--;

                    time++;
                    str = time + "_" + x + "_" + y;
                    countMap.put(str, countMap.getOrDefault(str, 0)+1);
                }

            }
        }

        int answer = 0;
        for (int v: countMap.values()) {
            if (v >= 2) answer++;
        }


        return answer;
    }
}