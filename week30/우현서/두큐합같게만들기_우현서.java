// 길이 같은 큐 두개
// 하나의 큐에서 원소 pop, 다른 큐에 insert
// 각 큐의 원소 합이 같게 하는 최소 횟수, 못하면 -1 리턴
// pop -> 첫 원소 추출, insert -> 끝에 추가

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int n = queue1.length;

        long sum1 = 0;
        for (int x: queue1) {
            q1.offer(x);
            sum1 += x;
        }
        long sum2 = 0;
        for (int x: queue2) {
            q2.offer(x);
            sum2 += x;
        }
        // System.out.println(q1);
        // System.out.println(q2);

        int result = 0;
        while (true) {
            if (result > 2*2*n) return -1;
            if (sum1 == sum2) break;

            if (sum1 < sum2) {
                int x = q2.poll();
                sum2 -= x;
                q1.offer(x);
                sum1 += x;
            } else {
                int x = q1.poll();
                sum1 -= x;
                q2.offer(x);
                sum2 += x;
            }
            result++;
        }

        return result;
    }
}