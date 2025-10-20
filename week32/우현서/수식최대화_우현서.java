// 우승자 상금 결정 방식
// 참가자들에게 숫자, +-*만으로 이루어진 연산 수식이 전달됨.
// 미션: 전달받은 수식에 포함된 연산자의 우선순위를 재정의해서 가장 큰 숫자 제출
// 2개 이상의 연산자가 동일한 순위를 가질 수는 없다
// 계산 결과가 음수면 절댓값으로 변환하여 제출
// 제출한 숫자가 가장 큰 참가자가 우승자, 이사람이 제출한 숫자를 우승상금으로 지급
// expression: 연산 수식 담긴 문자열, 중위 표기식, 공백/괄호 없음
// 가장 큰 상금 금액 리턴

// exp에 있는 연산자 확인해서 우선순위 돌수있는 순열 다 구하고 계산해보기?

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public long solution(String expression) {
        Set<Character> operators = new HashSet<>();
        for (char c: expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);
            }
        }
        // System.out.println(operators);

        List<Character> opList = new ArrayList<>(operators); // 리스트로 변환
        List<List<Character>> opPermute = new ArrayList<>(); // 연산자 우선순위 순열
        permute(opList, 0, opPermute);
        // System.out.println(opPermute);

        List<String> tokens = new ArrayList<>(); // 숫자,연산자로 토큰화
        String num = "";
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                tokens.add(num);
                tokens.add(String.valueOf(c));
                num = "";
            } else {
                num += c;
            }
        }
        tokens.add(num); // 마지막 숫자 추가
        // System.out.println(tokens);

        long result = 0;

        for (int i=0; i<opPermute.size(); i++) {
            List<Character> ops = opPermute.get(i);
            List<String> copiedTokens = new ArrayList<>(tokens);
            // System.out.println(ops);
            for (Character op: ops) {
                for (int j=0; j<copiedTokens.size(); j++) {
                    if (copiedTokens.get(j).equals(op.toString())) {
                        long a = Long.parseLong(copiedTokens.get(j-1));
                        long b = Long.parseLong(copiedTokens.get(j+1));
                        long temp = 0;
                        if (op == '+') {
                            temp = a + b;
                        } else if (op == '-') {
                            temp = a - b;
                        } else if (op == '*') {
                            temp = a * b;
                        }

                        copiedTokens.remove(j-1);
                        copiedTokens.remove(j-1);
                        copiedTokens.remove(j-1);
                        copiedTokens.add(j-1, Long.toString(temp));
                        j--;
                        // System.out.println(copiedTokens);
                    }
                }
            }
            // System.out.println();
            result = Math.max(result, Math.abs(Long.parseLong(copiedTokens.get(0))));
        }
        // System.out.println(result);

        return result;
    }

    void permute(List<Character> list, int start, List<List<Character>> result) {
        if (start == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, i, start);
            permute(list, start + 1, result);
            Collections.swap(list, i, start);
        }
    }
}