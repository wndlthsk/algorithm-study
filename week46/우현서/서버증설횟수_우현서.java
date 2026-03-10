// 같은 시간대 게임 이용자가 m명 늘어날때마다 서버 1대 추가 필요
// 증설된 서버는 k시간동안 운영후 반납
// 서버를 최소 몇번 증설해야하는지 리턴

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int now = 0;
        Queue<int[]> queue = new ArrayDeque<>(); // 반납시간, 개수
        for (int i=0; i<players.length; i++) {
            int p = players[i];

            int need = p / m;
            while(!queue.isEmpty() && queue.peek()[0] == i) {
                int[] expired = queue.poll();
                now -= expired[1];
            }

            if (need <= now) continue;
            else {
                int add = need - now;
                now += add;
                queue.add(new int[]{i+k, add});

                answer += add;
            }

        }

        return answer;
    }
}