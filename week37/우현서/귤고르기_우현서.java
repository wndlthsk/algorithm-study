// 크기별 분류했을 때 서로 다른 종류의 수를 최소화
// k개 골라 판매

// 리스트 정렬
// list.sort() / list.sort(Collections.reverseOrder())
// HashMap 정렬
// List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet()) 으로 변환 후
// 리스트를 정렬
// (값 기준 내림차순) : list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
// HahsMap for문
// for (Map.Entry<Integer, Integer> entry : map.entrySet())

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int x: tangerine) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(countMap.values());
        countList.sort(Collections.reverseOrder());
        // System.out.println(countList);

        int sum = 0;
        int result = 0;
        for (int x: countList) {
            sum += x;
            result++;
            if (sum >= k) break;
        }

        return result;
    }
}