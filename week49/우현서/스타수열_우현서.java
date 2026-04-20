// 스타 수열: 길이가 2이상인 짝수개의 수열로 된 부분 수열
// 교집합끼리의 교집합의 원소 개수가 1이상, 각 교집합은 서로 다른 숫자로 구성
// 가장 길이가 긴 스타 수열의 길이 리턴
// 스타 수열 없으면 0 리턴

// 모든 쌍에 공통으로 들어가는 숫자 x가 존재해야 한다
// x를 하나 고정하고 그 x가 들어간 쌍만 만들면 된다

// x를 정했을때 최대 길이는 x개수 *2이다. 이게  <= 현재 최대 길이 이면 가지치기

// Map 반복문 돌기 : for (Map.Entry<Integer, Integer> entry : map.entrySet())

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] a) {
        int answer = -1;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int x: a) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }
        // System.out.println(countMap);


        for (int x: countMap.keySet()) {
            if (countMap.get(x) * 2 <= answer) continue;

            // 위치 고려돼야함
            int pairs = 0;
            for (int i=0; i<a.length-1; i++) {
                if (a[i] != a[i+1] && (a[i] == x || a[i+1] == x)) {
                    pairs++;
                    i++;
                }
            }

            answer = Math.max(answer, pairs*2);
        }

        return answer;
    }
}