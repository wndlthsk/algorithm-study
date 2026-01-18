// 각 유저는 한번에 한명 신고 가능, 여러번 신고해도 횟수는 1회로 처리
// k번 이상 신고된 유저는 게시판 이용 정지, 해당 유저를 신고한 모든 유저에게 메일 발송

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> users = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            users.put(id_list[i], i);
        }

        Set<String> reports = new HashSet<>();
        for (String r: report) {
            reports.add(r);
        }

        Map<String, Set<String>> reportedBy = new HashMap<>();

        for (String r: reports) {
            String[] splited = r.split(" ");

            reportedBy.computeIfAbsent(splited[1], a-> new HashSet<>()).add(splited[0]);
        }


        int[] result = new int[id_list.length];
        for (Map.Entry<String, Set<String>> rb: reportedBy.entrySet()) {
            String reported = rb.getKey();
            Set<String> reporters = rb.getValue();

            if (reporters.size() < k) continue;
            for (String reporter : reporters) {
                result[users.get(reporter)]++;
            }
        }

        return result;
    }
}