// 연산자 우선순위 재정의 해서 가장 큰 숫자 제출
// 같은 순위는 없음
// 결과가 음수면 절댓값으로 제출

// 연산자 따로 모아서 dfs로 우선순위 조합 구하고 모든 경우 계산해보기

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<Character> ops;

    public long solution(String expression) {
        char[] chars = expression.toCharArray();
        ops = new HashSet<>();
        List<Character> opList = new ArrayList<>();

        for (char c: chars) {
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                opList.add(c);
            }
        }

        combination(new ArrayList<>());
        // System.out.println(candidates);

        String[] splited = expression.split("\\+|\\-|\\*");
        List<Long> numList = new ArrayList<>();
        for (String s: splited) {
            numList.add(Long.parseLong(s));
        }

        long answer = 0;
        for (List<Character> op: candidates) {
            long temp = calculate(numList, opList, op);
            if (temp < 0) temp = Math.abs(temp);
            answer = Math.max(answer, temp);
        }

        return answer;
    }

    // 우선순위 조합
    List<List<Character>> candidates = new ArrayList<>();
    Set<Character> visited = new HashSet<>();

    private void combination(List<Character> now) {
        if (now.size() == ops.size()) {
            candidates.add(new ArrayList<>(now));
            return;
        }

        for (char c: ops) {
            if (visited.contains(c)) continue;

            now.add(c);
            visited.add(c);
            combination(now);
            now.remove(now.size()-1);
            visited.remove(c);
        }

    }

    private long calculate(List<Long> originNums, List<Character> originOps, List<Character> priority) {
        List<Long> nums = new ArrayList<>(originNums);
        List<Character> opList = new ArrayList<>(originOps);

        for (char target : priority) {
            for (int i = 0; i < opList.size(); i++) {
                if (opList.get(i) == target) {
                    long result = calc(nums.get(i), nums.get(i + 1), target);

                    nums.set(i, result);
                    nums.remove(i + 1);
                    opList.remove(i);

                    i--;
                }
            }
        }

        return nums.get(0);
    }

    private long calc(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
}