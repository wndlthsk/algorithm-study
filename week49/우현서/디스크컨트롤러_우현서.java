// 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // 요청 시각
            return a[1] - b[1]; // 소요 시간
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // 소요 시간 짧은 순
            return a[0] - b[0]; // 요청 시각 빠른 순
        });

        int time = 0;
        int idx = 0;
        int total = 0;
        int count = 0;
        int n = jobs.length;

        while (count < n) {
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }

            int[] job = pq.poll();
            int request = job[0];
            int duration = job[1];

            time += duration;
            total += (time - request);
            count++;
        }

        return total / n;
    }
}