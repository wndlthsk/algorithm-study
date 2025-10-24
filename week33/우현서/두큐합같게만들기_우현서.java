// 길이 같은 큐 두개
// 하나의 큐에서 원소 pop, 다른 큐에 insert
// 각 큐의 원소 합이 같게 하는 최소 횟수, 못하면 -1 리턴
// pop -> 첫 원소 추출, insert -> 끝에 추가

// 두 큐의 합 비교하면서 큰곳에서 poll, 작은 곳에 add
// 같아질 때까지 카운트,
// 초기 원소 개수보다 많이 반복하면 불가능?


import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        for (int x: queue1) {
            q1.add(x);
            sum1 += x;
        }
        long sum2 = 0;
        for (int x: queue2) {
            q2.add(x);
            sum2 += x;
        }
        // System.out.println(q1);

        int result = 0;

        while(result <= 3 * n) {
            if (sum1 == sum2) return result;

            if (sum1 > sum2) {
                int x = q1.poll();
                sum1 -= x;
                q2.add(x);
                sum2 += x;
                result++;
            } else {
                int x = q2.poll();
                sum2 -= x;
                q1.add(x);
                sum1 += x;
                result++;
            }

        }

        return -1;
    }
}