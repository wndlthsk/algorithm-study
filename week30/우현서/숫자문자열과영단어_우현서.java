// 숫자에서 일부 자릿수를 영단어로 바꾼 카드를 주면 원래 숫자를 찾는 게임
// 48~57 숫자
// 97~122 영소문자

// StringBuilder append
// Set add
// List add
// Map put

// Integer.valueOf("123") -> Interger 123
// Integer.valueOf('9') -> Integer 57
// Integer.valueOf("9") -> Integer 9
// Integer.parseInt("123") -> int 123
// Integer.toString(123) -> String 123
// String.valueOf(123) -> String 123
// Double.parseDouble("3.14") -> Double 3.14

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        Map<String, Integer> engNum = new HashMap<>();
        engNum.put("zero", 0);
        engNum.put("one", 1);
        engNum.put("two", 2);
        engNum.put("three", 3);
        engNum.put("four", 4);
        engNum.put("five", 5);
        engNum.put("six", 6);
        engNum.put("seven", 7);
        engNum.put("eight", 8);
        engNum.put("nine", 9);

        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                result.append(c);
            }
            else {
                sb.append(c);
                String temp = sb.toString();
                if (engNum.containsKey(temp)) {
                    // sb = new StringBuilder();
                    sb.setLength(0); // 기존 sb 비우기
                    result.append(engNum.get(temp));
                }
            }
        }

        return Integer.parseInt(result.toString());
    }
}