package week33.우현서;// 괄호 개수는 맞지만 짝이 맞지 않는 오류
// 모든 괄호를 뽑아 올바른 순서대로 배치된 괄호 문자열을 리턴

// ()로만 이루어진 문자열
// 둘의 개수가 같으면 -> 균형 잡힌 괄호 문자열
// ()의 짝도 모두 같으면 -> 올바른 괄호 문자열
// 균형잡힌 괄호 문자열이면 과정을 통해 올바른 괄호 문자열로 변환가능
// 빈문자열인 경우 빈문자열 반환
// w를 u,v로 분리, u는 균형잡힌 괄호 문자열로 더이상 분리할 수 없어야함. v는 빈문자열일수도
// u가 올바른 괄호 문자열이면 v를 1단계부터 다시 수행
// 결과를 u에 이어붙여 반환
// u가 올바른 괄호 문자열이 아니라면
// 빈문자열에 첫번째 문자로 ( 를 붙임
// v에 대해 1단계부터 재귀적으로 수행한 결과를 이어 붙임
// )를 다시 붙임
// u의 첫, 마지막 문자제거, 나머지 문자열의 괄호 방향을 뒤집어 뒤에 붙임
// 생성된 문자열을 반환

// p: 균형잡힌 괄호 문자열
// p를 올바른 괄호 문자열로 변환한 결과를 리턴

class Solution {
    public String solution(String p) {
        String answer = change(p);
        return answer;
    }

    public String change(String s) {
        // 1. 빈문자열인 경우 빈문자열 반환
        if (s.equals("")) return s;

        // 2. w를 u,v로 분리, u는 균형잡힌 괄호 문자열로 더이상 분리할 수 없어야함. v는 빈문자열일수도
        String[] uv = splitUV(s);
        String u = uv[0];
        String v = uv[1];

        // 3. u가 올바른 괄호 문자열이면 v를 1단계부터 다시 수행
        if (isRight(u)) {
            String vResult = change(v);
            return u + vResult;
        }
        // 4. u가 올바른 괄호 문자열이 아니라면
        else {
            // 4-1. 빈문자열에 첫번째 문자로 ( 를 붙임
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            // 4-2. v에 대해 1단계부터 재귀적으로 수행한 결과를 이어 붙임
            sb.append(change(v));

            // 4-3. )를 다시 붙임
            sb.append(")");

            // 4-4. u의 첫, 마지막 문자제거, 나머지 문자열의 괄호 방향을 뒤집어 뒤에 붙임
            String deleted = u.substring(1, u.length() - 1); // substring(begin, end): begin~end-1
            StringBuilder flipped = new StringBuilder();
            for (char c: deleted.toCharArray()) {
                if (c=='(') {
                    flipped.append(")");
                } else {
                    flipped.append("(");
                }
            }
            sb.append(flipped.toString());

            // 4-5. 생성된 문자열을 반환
            return sb.toString();
        }
    }

    public String[] splitUV(String w) {
        int open = 0;
        int close = 0;
        int index = 0;

        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(i);
            if (ch == '(') open++;
            else if (ch == ')') close++;

            // 균형이 맞는 순간
            if (open == close) {
                index = i + 1; // 균형잡힌 첫 구간의 끝
                break;
            }
        }

        String u = w.substring(0, index);
        String v = (index < w.length()) ? w.substring(index) : "";

        return new String[]{u, v};
    }

    public boolean isRight(String s) {
        int openCount = 0;
        int closeCount = 0;
        boolean isRight = true;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                closeCount++;
                if (closeCount > openCount) {
                    isRight = false;
                    break;
                }
            }
        }

        if (openCount != closeCount) {
            isRight = false;
        }

        return isRight;
    }
}