// 조각 모아서 소수 몇개 만들수 있는지

import java.util.HashSet;
import java.util.Set;

class Solution {
    char[] chars;

    public int solution(String numbers) {
        int answer = 0;
        chars = numbers.toCharArray();

        int n = numbers.length();
        visited = new boolean[n];

        for (int i=1; i<=n; i++) {
            permutation(n, i, new StringBuilder());
        }

        return result.size();
    }

    boolean[] visited;
    Set<Integer> result = new HashSet<>();

    public void permutation(int n, int k, StringBuilder sb) {
        if (sb.length()==k) {
            int num = Integer.parseInt(sb.toString());

            if (isPrime(num)) result.add(num);

            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            sb.append(chars[i]);

            permutation(n, k, sb);

            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}