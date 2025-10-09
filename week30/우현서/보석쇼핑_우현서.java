// 진열대의 특정 범위의 보석을 모두 구매,
// 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
// gems: 진열대 번호 순서대로 보석 이름 저장된 배열
// 가장 짧은 구간의 시작 진열대 번호, 끝 진열대 번호 배열로 리턴
// 만약 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간

// 보석 모든 종류를 알아야함
// dfs/bfs로 짧은 구간 찾기? -> dfs: O(n² × 종류 수)로 불가
// 슬라이딩 윈도우 + 투포인터

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[] solution(String[] gems) {
        // names: 모든 보석 종류
        Set<String> names = new HashSet<>();
        for (String gem: gems) {
            names.add(gem);
        }
        int totalNames = names.size();

        // now: 현재 모은 (보석, 개수)
        Map<String, Integer> now = new HashMap<>();

        int[] result = new int[2];

        int left = 0;
        int right = 0;
        int minLen = 100001;

        while (left <= right) {
            if (right == gems.length && now.size() < totalNames) {
                break;
            }
            // 모든 종류 다 모았으면 최소 길이 갱신, left 증가
            if (now.size() == totalNames) {
                if (right - left < minLen) {
                    result[0] = left + 1;
                    result[1] = right;
                    minLen = right - left;
                }

                String temp = gems[left];
                now.put(temp, now.get(temp) - 1);
                if (now.get(temp) == 0) {
                    now.remove(temp);
                }
                left++;
            } else { // 모든 종류 덜 모았으면 오른쪽 증가
                now.put(gems[right], now.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }

        return result;
    }
}