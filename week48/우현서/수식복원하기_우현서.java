// 2~9진법 중 찾아서 수식 계산

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    int maxDigit;

    public String[] solution(String[] expressions) {
        maxDigit = 0;

        // maxDigit, notIncludeX, includeX 구하기
        List<String> notIncludeX = new ArrayList<>();
        List<String> includeX = new ArrayList<>();
        for (String exp: expressions) {
            String[] splited = exp.split(" ");
            String num1 = splited[0];
            String num2 = splited[2];
            String num3 = splited[4];

            checkForMaxDigit(num1.toCharArray());
            checkForMaxDigit(num2.toCharArray());

            if (num3.equals("X")) {
                includeX.add(exp);
            } else {
                checkForMaxDigit(num3.toCharArray());
                notIncludeX.add(exp);
            }
        }

        // 후보 진법 구하기
        List<Integer> candidates = new ArrayList<>();
        for (int base = maxDigit+1; base <= 9; base++) {
            boolean isPossible = true;

            // X 없는 식에서 성립하는지 확인
            for (String exp: notIncludeX) {
                String[] splited = exp.split(" ");

                String op = splited[1];
                int num1 = toDecimal(splited[0], base);
                int num2 = toDecimal(splited[2], base);
                int num3 = toDecimal(splited[4], base);

                int result = 0;
                if (op.equals("+")) {
                    result = num1 + num2;
                } else { // 뺄셈
                    result = num1 - num2;
                }

                if (result != num3) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) continue;
            else candidates.add(base);
        }


        // X 있는 식에서 후보 진법 값 비교
        List<String> answer = new ArrayList<>();
        for (String exp: includeX) {
            String[] splited = exp.split(" ");
            String op = splited[1];

            Set<String> num3 = new HashSet<>(); // 계산 결과 Set

            for (int base: candidates) {
                int num1 = toDecimal(splited[0], base);
                int num2 = toDecimal(splited[2], base);

                int result = 0;
                if (op.equals("+")) {
                    result = num1 + num2;
                } else {
                    result = num1 - num2;
                }

                String changed = toBase(result, base);
                num3.add(changed);
                if (num3.size() > 1) break;
            }

            // 식 완성
            splited[4] = (num3.size() > 1) ? "?" : num3.iterator().next();


            String joined = String.join(" ", splited);
            answer.add(joined);
        }

        return answer.toArray(new String[0]);
    }

    // 식에 최대 숫자 구하기
    private void checkForMaxDigit(char[] chars) {
        for (char c: chars) {
            int num = c - '0';
            maxDigit = Math.max(maxDigit, num);
        }
    }

    // n진법 -> 10진법
    private int toDecimal(String s, int base) {
        int result = 0;

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            result = result * base + digit;
        }

        return result;
    }

    // 10진법 -> n진법
    private String toBase(int num, int base) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }

        return sb.reverse().toString();
    }

}