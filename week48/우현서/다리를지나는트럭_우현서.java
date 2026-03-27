// 모든 트럭이 다리 건너는데 걸리는 시간
// 최대 bridge_length대, weight 이하 무게
//

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<bridge_length; i++) {
            queue.offer(0);
        }
        int total = 0;

        int n = truck_weights.length;
        int idx = 0;
        int time = 0;
        while (idx < n || total > 0) {
            int out = queue.poll();
            total -= out;

            if (idx < n) {
                int in = truck_weights[idx];

                if (total + in <= weight) {
                    total += in;
                    queue.offer(in);
                    idx++;
                } else {
                    queue.offer(0);
                }
            }

            time++;
        }

        return time;
    }
}