// orders의 각 주문 목록 오름차순 정렬
// 조합 함수
// for문 돌면서 개수 세기, 1개이하면 후보에서 제외

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        for (int i=0; i<orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }
        // System.out.println(Arrays.toString(orders));

        List<String> result = new ArrayList<>();

        for (int targetLength: course) {
            Map<String, Integer> map = new HashMap<>();
            for (String o: orders) {
                char[] order = o.toCharArray();
                combine(order, 0, targetLength, new StringBuilder(), map);
            }
            // System.out.println(map);

            if (map.isEmpty()) continue;
            int maxValue = Collections.max(map.values());
            if (maxValue < 2) continue;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    result.add(entry.getKey());
                }
            }

        }
        // System.out.println(result);

        Collections.sort(result);
        // System.out.println(result);

        return result.toArray(new String[0]);
    }

    public void combine(char[] order, int start, int targetLength, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == targetLength) {
            String comb = sb.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = start; i < order.length; i++) {
            sb.append(order[i]);
            combine(order, i + 1, targetLength, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}