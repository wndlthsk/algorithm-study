// 동일한 가짓수의 토핑이 있게
// 경우의 수 리턴

// 자르는 곳을 포인터로 생각하자

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int count = 0;

        Set<Integer> first = new HashSet<>();

        Map<Integer, Integer> second = new HashMap<>();
        for (int t: topping) {
            second.put(t, second.getOrDefault(t, 0) + 1);
        }

        for (int pointer=0; pointer < topping.length-1; pointer++) {
            int t = topping[pointer];

            first.add(t);

            if (second.get(t) == 1) second.remove(t);
            else second.put(t, second.get(t) - 1);

            if (first.size() == second.size()) count++;
        }

        return count;
    }
}