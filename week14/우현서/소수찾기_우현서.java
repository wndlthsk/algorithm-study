// 한자리 숫자가 적힌 종이
// 종이 조각을 붙여 만들 수 있는 소수의 개수 구하기

// numbers의 숫자(n개) 중에서 1개~n개의 순열 구한후, 소수이면 카운트
// 중복 처리 -> set 사용, 앞자리 0 처리-> integer로 넣기
import java.util.*;

class Solution {
    Set<Integer> result = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        int n = numbers.length();

        visited = new boolean[n];

        permutation(numbers, "");
        // System.out.println(result);

        for (int x: result) {
            if (isPrime(x)) answer++;
        }

        return answer;
    }

    // 순열
    private void permutation(String numbers, String current) {
        if (!current.equals("")) {
            result.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    // 소수 여부
    private boolean isPrime(int x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}