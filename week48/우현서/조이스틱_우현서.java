class Solution {
    public int solution(String name) {
        int answer = 0;

        for (char c: name.toCharArray()) {
            int diff = Math.abs('A' - c);
            if (diff >= 13) {
                diff = 26 - diff;
            }
            answer += diff;
        }

        int n = name.length();
        int move = n-1;
        for (int i=0; i<n; i++) {
            int next = i+1;
            while(next < n && name.charAt(next)=='A') {
                next++;
            }

            int try1 = i + i + n-next;
            int try2 = n-next + n-next + i;
            move = Math.min(move, Math.min(try1, try2));
        }
        answer += move;

        return answer;
    }
}