// 모든 조건 만족하는 경우의 수 리턴

class Solution {
    String[] data;

    public int solution(int n, String[] data) {
        this.data = data;

        permutation(new boolean[8], new StringBuilder());

        return answer;
    }

    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;

    public void permutation(boolean[] visited, StringBuilder sb) {
        if (sb.length() == 8) {
            if (isPossible(sb.toString())) answer++;
            return;
        }

        for (int i=0; i<8; i++) {
            if (visited[i]) continue;

            sb.append(friends[i]);
            visited[i] = true;

            permutation(visited, sb);

            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }

    private boolean isPossible(String candidate) {
        for (String d: data) {
            char a = d.charAt(0);
            char b = d.charAt(2);
            char op = d.charAt(3);
            int v = d.charAt(4) - '0';

            int ra = candidate.indexOf(a);
            int rb = candidate.indexOf(b);
            int diff = Math.abs(ra - rb);

            if (op == '=') {
                if (diff != v+1) return false;
            } else if (op == '>') {
                if (diff <= v+1) return false;
            } else if (op == '<') {
                if (diff >= v+1) return false;
            }
        }

        return true;
    }


}