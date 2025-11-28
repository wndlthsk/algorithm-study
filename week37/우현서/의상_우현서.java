// 매일 다른 옷 조합
// 각 종류별 1개
// 서로 다른 옷의 조합 수 리턴
// [의상의 이름, 의상의 종류]

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> countMap = new HashMap<>();
        for (String[] c: clothes) {
            countMap.put(c[1], countMap.getOrDefault(c[1], 0) + 1);
        }
        // System.out.println(countMap);

        for (Map.Entry<String, Integer> c: countMap.entrySet()) {
            answer *= c.getValue() + 1;
        }
        // 다 안 입은 경우의 수 제외
        answer -= 1;

        return answer;
    }
}