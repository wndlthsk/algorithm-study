// x칸만큼 회전했을때 올바른 괄호 되는 거 개수
// stack으로 괄호 체크

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    int n;
    char[] chars;

    public int solution(String s) {
        int answer = 0;

        n = s.length();
        chars = s.toCharArray();

        for (int x=0; x<n; x++) {
            if (isRight(x)) answer++;
        }

        return answer;
    }

    private boolean isRight(int start) {
        Deque<Character> stack = new ArrayDeque<>();
        int idx = start;

        for (int i=0; i<n; i++) {
            char c = chars[idx];

            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }

            idx++;
            if (idx == n) idx = 0;

        }

        return stack.isEmpty();
    }
}