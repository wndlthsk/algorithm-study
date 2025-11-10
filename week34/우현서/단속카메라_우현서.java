// 모든 차량이 한번은 카메라 만나도록하는 최소 카메라 대수 구하기
// routes: 차량 경로
// routes[i][0]: 진입 시점, [i][1]: 나간 시점

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        System.out.println(Arrays.deepToString(routes));

        int answer = 1;
        int before = routes[0][1];
        for (int i=1; i<routes.length; i++) {
            if (routes[i][0] <= before) continue;
            before = routes[i][1];
            answer++;
        }

        return answer;
    }
}