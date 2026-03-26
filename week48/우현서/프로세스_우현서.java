// 몇번째로 실행되는지

import java.util.LinkedList;
import java.util.Queue;

class Process {
    int idx;
    int num;

    public Process (int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();

        for (int i=0; i<priorities.length; i++) {
            Process process = new Process(i, priorities[i]);
            queue.offer(process);
        }

        int answer = 1;
        while (!queue.isEmpty()) {
            Process now = queue.poll();

            boolean hasHigher = false;
            for (Process p: queue) {
                if (now.num < p.num) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(now);
            } else {
                if (now.idx == location) {
                    return answer;
                }
                answer++;
            }

        }

        return answer;
    }
}