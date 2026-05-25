// 숫자 일부를 영어로 주어질때 원래 숫자로 리턴

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        char[] chars = s.toCharArray();

        Map<String, Integer> numMap = new HashMap<>();
        numMap.put("zero", 0);
        numMap.put("one", 1);
        numMap.put("two", 2);
        numMap.put("three", 3);
        numMap.put("four", 4);
        numMap.put("five", 5);
        numMap.put("six", 6);
        numMap.put("seven", 7);
        numMap.put("eight", 8);
        numMap.put("nine", 9);

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (char c: chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                temp.append(c);

                if (numMap.containsKey(temp.toString())) {
                    sb.append(numMap.get(temp.toString()));
                    temp.setLength(0); // sb 초기화
                }
            }
        }


        return Integer.parseInt(sb.toString());
    }
}