// 제재 아이디 경우의 수
// 각 불량 사용자별로 경우의수 구해서 곱하기 -> 안됨! 예제 2참고

// 리스트 정렬
// 오름차순: Collections.sort(list); / list.sort(null);
// 내림차순: list.sort((a, b) -> b.compareTo(a));

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<String, List<String>> candidates;
    String[] banned_id;

    public int solution(String[] user_id, String[] banned_id) {
        this.banned_id = banned_id;

        candidates = new HashMap<>();

        for (String b: banned_id) {
            if (candidates.containsKey(b)) continue; // 이미 후보들 찾은 건 건너뜀

            for (String u: user_id) {
                if (!isPossible(u, b)) continue;

                candidates.computeIfAbsent(b, k->new ArrayList<>()).add(u); // 후보에 포함
            }
        }

        dfs(0, new HashSet<>());

        return result.size();
    }

    private boolean isPossible (String user, String banned) {
        if (user.length() != banned.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }

        return true;
    }


    Set<String> result = new HashSet<>();

    private void dfs(int idx, Set<String> visited) {
        if (idx == banned_id.length) { // 목록 완성됐으면
            List<String> list = new ArrayList<>(visited);
            Collections.sort(list); // 정렬해서
            result.add(String.join(",", list)); // 최종목록에 삽입

            return;
        }

        for (String c: candidates.get(banned_id[idx])) { // 후보들 돌면서
            if (visited.contains(c)) continue; // 이미 선택한건 건너뜀

            visited.add(c);
            dfs(idx+1, visited);
            visited.remove(c);
        }

    }

}