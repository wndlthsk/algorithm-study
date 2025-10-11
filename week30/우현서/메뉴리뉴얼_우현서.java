// 가장 많이 함께 주문한 단품메뉴를 코스요리 메뉴로 구성
// 최소 2개 이상의 단품메뉴로 구성
// 최소 2명 이상의 손님이 주문한 단품메뉴 조합만 후보에 포함
// orders: 각 손님들이 주문한 단품메뉴들 문자열 배열
// course: 단품메뉴들의 개수 배열, 오름차순 정렬
// 새로 추가하게 될 코스요리의 메뉴 구성 리턴, 오름차순 정렬, 가장 많이 함께 주문된 메뉴 구성이 여러 개이면 모두 포함,

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for(int c: course) {
            Map<String, Integer> menuCount = new HashMap<>();

            for (String order: orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                // System.out.println(Arrays.toString(chars));
                combine(new String(chars), 0, c, new StringBuilder(), menuCount);
            }
            // System.out.println(menuCount);

            if (menuCount.isEmpty()) continue;

            int maxValue = Collections.max(menuCount.values());
            if (maxValue < 2) continue;

            for (String menu: menuCount.keySet()) {
                if (menuCount.get(menu) == maxValue) {
                    result.add(menu);
                }
            }
        }
        Collections.sort(result);


        return result.toArray(new String[result.size()]);
    }

    void combine(String order, int start, int r, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == r) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combine(order, i + 1, r, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}