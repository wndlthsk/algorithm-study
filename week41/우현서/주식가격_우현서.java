// prices: 초 단위 주식 가격
// 가격 떨어지지 않은 기간 배열 리턴

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                int j = stack.pollLast();
                // System.out.println("i: " + i + " j: " + j );
                answer[j] = i-j;
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int x = stack.pollLast();
            answer[x] = n-1-x;
        }

        return answer;
    }
}