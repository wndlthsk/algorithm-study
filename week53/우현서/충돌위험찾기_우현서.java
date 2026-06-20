// 같은 좌표에 로봇 2대 이상 몇번인지

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int n = routes.length;

        Map<String, Integer> countMap = new HashMap<>();

        for (int i=0; i<n; i++) {
            int[] route = routes[i];
            int time = 0;

            int x = points[route[0]-1][0];
            int y = points[route[0]-1][1];

            String str = time + "-" + x + "-" + y;
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);

            for (int j=1; j<route.length; j++) {
                int tx = points[route[j]-1][0];
                int ty = points[route[j]-1][1];

                while (x != tx) {
                    if (x < tx) x++;
                    else x--;

                    time++;
                    str = time + "-" + x + "-" + y;
                    countMap.put(str, countMap.getOrDefault(str, 0) + 1);
                }

                while (y != ty) {
                    if (y < ty) y++;
                    else y--;

                    time++;
                    str = time + "-" + x + "-" + y;
                    countMap.put(str, countMap.getOrDefault(str, 0) + 1);
                }
            }
        }

        int answer = 0;
        for (int v: countMap.values()) {
            if (v > 1) answer++;
        }


        return answer;
    }
}