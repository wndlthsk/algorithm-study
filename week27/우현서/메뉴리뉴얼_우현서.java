// 단품 메뉴 조합후 코스 형태로 재구성
// 가장 많이 함께 주문한 단품 메뉴를 코스로 구성
// 코스 메뉴킄 최소 2가지 이상 단품으로 구성
// 최소 2명 이상이 주문한 단품 메뉴 조합에서만 코스에 포함

// 문자열 형식 오름차순 리턴

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }
        Arrays.sort(orders);
        // System.out.println(Arrays.toString(orders));

        List<Map<String, Integer>> mapList = new ArrayList<>();
        for (int target: course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order: orders) {
                combine(order.toCharArray(), 0, 0, target, new StringBuilder(), map);
            }
            mapList.add(map);
        }
        // System.out.println(mapList);

        List<String> resultList = new ArrayList<>();

        for (Map<String, Integer> map: mapList) {
            if (map.isEmpty()) continue; // 비어있으면 건너뜀

            int maxCount = Collections.max(map.values());
            if (maxCount < 2) continue; // 최소 2명 이상 조건

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    resultList.add(entry.getKey());
                }
            }
        }
        // System.out.println(resultList);

        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }

    public void combine(char[] order, int start, int depth, int targetLength, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == targetLength) {
            String comb = sb.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = start; i < order.length; i++) {
            sb.append(order[i]);
            combine(order, i + 1, depth + 1, targetLength, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}