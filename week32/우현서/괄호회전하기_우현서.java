import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        for (int x =0; x<n; x++){
            String newS = s.substring(x,n)+s.substring(0,x);
            // System.out.println(newS);

            boolean flag = true;
            Deque<Character> stack = new ArrayDeque<>();
            for (int i=0; i<n; i++) {
                char c = newS.charAt(i);
                if(c=='(' || c=='[' || c=='{') {
                    stack.add(c);
                }
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    char top = stack.pollLast();
                    if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.isEmpty()) answer++;

        }
        return answer;
    }
}