// 중복된 원소 가능
// 순서있음
// 원소 개수는 유한
// 원소 개수 n, 중복 원소가 없는 튜플 -> {}로 표현
// 앞 원소부터 {{a1}, {a1, a2}, {a1, a2, a3}, ..
// s가 표현하는 튜플을 리턴

// 순서 유지하는 set
// -> LinkedHashSet (추가된 순서 유지) / TreeSet (정렬 순서 유지)

// hashset, linkedhashset 둘다 인덱스로 조회 안됨
// -> nums.stream().mapToInt(Integer::parseInt).toArray();

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        String[] splited = s.substring(2, s.length()-2).split("\\},\\{");
        Arrays.sort(splited, (a, b) -> Integer.compare(a.length(), b.length()));

        Set<String> nums = new LinkedHashSet<>();
        for (String sp: splited) {
            String[] splited2 = sp.split(",");
            for (String sp2: splited2) {
                nums.add(sp2);
            }
        }

        int[] result = nums.stream().mapToInt(Integer::parseInt).toArray();

        return result;
    }
}