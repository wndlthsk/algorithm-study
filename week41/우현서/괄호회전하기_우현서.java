import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        char[] chars = s.toCharArray();

        for (int x=0; x<n; x++) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;

            for (int i=0; i<n; i++) {
                int idx = (x+i) % n;

                if (chars[idx] == '(' || chars[idx] == '{' || chars[idx] == '[') stack.push(chars[idx]);
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }

                    Character before = stack.pop();

                    if (chars[idx] == ')' && before != '('
                        || chars[idx] == '}' && before != '{'
                        || chars[idx] == ']' && before != '[') {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty()) answer++;
        }

        return answer;
    }
}