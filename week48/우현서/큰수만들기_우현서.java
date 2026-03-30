// 숫자에서 k개 수 제거 후 얻을 수 있는 가장 큰 숫자 구하기

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        int n = number.length();
        char[] chars = number.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        stack.addLast(chars[0]);

        for(int i=1; i<n; i++) {
            while(!stack.isEmpty() && k > 0 && stack.peekLast() < chars[i]) {
                stack.pollLast();
                k--;
            }
            stack.addLast(chars[i]);
        }

        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }


        return sb.toString();
    }
}