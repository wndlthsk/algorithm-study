// 정렬해서 set 관리
// “여러 칸에 뭔가를 하나씩 배정하는데, 조건 때문에 일부 조합은 못 쓰는 문제” → 거의 백트래킹

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Integer, List<String>> candidates = new HashMap<>();;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        for (String user: user_id) {
            char[] chars1 = user.toCharArray();
            int len1 = user.length();
            for (int b=0; b<banned_id.length; b++) {
                String banned = banned_id[b];

                if (len1 != banned.length()) continue;

                char[] chars2 = banned.toCharArray();
                boolean isSame = true;
                for (int i=0; i<len1; i++) {
                    if  (chars2[i] != '*' && chars1[i] != chars2[i]) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    List<String> list = candidates.getOrDefault(b, new ArrayList<>());
                    list.add(user);
                    candidates.put(b, list);
                }
            }
        }
        // System.out.println(candidates);

        backtrack(banned_id.length, 0, new ArrayList<>());
        // System.out.println(result);

        return result.size();
    }

    Set<List<String>> result = new HashSet<>();

    public void backtrack(int len, int idx, List<String> now) {
        if (idx == len) {
            List<String> copy = new ArrayList<>(now);
            Collections.sort(copy);
            result.add(copy);
            return;
        }

        for (String s: candidates.get(idx)) {
            if (now.contains(s)) continue;
            now.add(s);
            backtrack(len, idx+1, now);
            now.remove(now.size()-1);
        }
    }
}