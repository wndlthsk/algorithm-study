import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        for (String order: orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            String sortedOrder = new String(arr);
            for (int c: course) {
                combination(sortedOrder, 0, c, new StringBuilder());
            }
        }
        // System.out.println(countMap);

        List<String> result = new ArrayList<>();

        for (int c : course) {
            int max = 0;

            for (Map.Entry<String, Integer> e : countMap.entrySet()) {
                if (e.getKey().length() == c) {
                    max = Math.max(max, e.getValue());
                }
            }

            if (max < 2) continue;

            for (Map.Entry<String, Integer> e : countMap.entrySet()) {
                if (e.getKey().length() == c && e.getValue() == max) {
                    result.add(e.getKey());
                }
            }
        }

        Collections.sort(result);
        // System.out.println(result);


        return result.toArray(new String[0]);
    }

    Map<String, Integer> countMap = new HashMap<>();

    public void combination(String order, int start, int r, StringBuilder sb) {
        if (sb.length() == r) {
            countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i=start; i<order.length(); i++) {
            sb.append(order.charAt(i));
            combination(order, i+1, r, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}