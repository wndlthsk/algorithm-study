// 어떤 숫자에서 k개 제거했을때 가장 큰 숫자 구하기

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char n: number.toCharArray()) {
            while (!stack.isEmpty() && stack.peekLast() < n && k > 0) {
                stack.pollLast();
                k--;
            }
            stack.addLast(n);
        }

        // 덜 뺀거 처리
        while(k > 0) {
            stack.pollLast();
            k--;
        }
        // System.out.println(stack);

        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }


        return sb.toString();
    }
}