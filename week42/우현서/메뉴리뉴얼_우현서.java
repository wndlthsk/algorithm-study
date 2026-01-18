// 단품 메뉴들 코스 형태로 재구성, 가장 많이 함께 주문한 단품 메뉴들을 코스메뉴로 구성
// 2가지 이상 단품메뉴로 구성, 2명 이상의 손님으로 부터 주문된 단품 조합에 대해서만 포함
// orders: 단품메뉴 문자열 형식
// course: 코스 구성하는 단품 갯수, 오름차순
// 코스료리 메뉴 구성 문자열 배열로 사전순 오름차순 리턴, 가장 많이 주문된 메뉴 구성이 여러개면 모두 리턴

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 각 주문마다 코스 구성 개수만큼 조합 구하기
        for (String order: orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            String sortedOrder = new String(arr);

            for (int c: course) {
                if (c > sortedOrder.length()) continue;
                combination(sortedOrder, c, new StringBuilder(), 0);
            }
        }
        // System.out.println(candidates);

        // 코스 구성 개수별 단품 조합 주문 횟수 최댓값
        Map<Integer, Integer> cntMax = new HashMap<>();
        for (Map.Entry<String, Integer> can: candidates.entrySet()) {
            String menu = can.getKey();
            int count = can.getValue();

            if (count < 2) continue;
            cntMax.put(menu.length(), Math.max(cntMax.getOrDefault(menu.length(), 0), count));
        }
        // System.out.println(cntMax);

        // 모든 조합 후보 중 최댓값과 같은 거 구하기
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> can: candidates.entrySet()) {
            String menu = can.getKey();
            int count = can.getValue();

            if (count < 2) continue;
            if (count == cntMax.get(menu.length())) result.add(menu);
        }
        Collections.sort(result);
        // System.out.println(result);


        return result.toArray(new String[0]);
    }

    Map<String, Integer> candidates = new HashMap<>();

    public void combination(String s, int r, StringBuilder sb, int start) {
        if (sb.length() == r) {
            candidates.put(sb.toString(), candidates.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i=start; i<s.length(); i++) {
            sb.append(s.charAt(i));
            combination(s, r, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}