// 유저는 한번에 한명 신고 가능, 동일 유저에 대해서는 여러번 신고해도 1회로 처리됨
// k번 이상 신고된 유저는 이용 정지, 해당 유저를 신고한 모든 유저에게 한꺼번에 메일 발송

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Reported {
    int count;
    Set<String> from;

    public Reported (int count, Set<String> from) {
        this.count = count;
        this.from = from;
    }

    @Override
    public String toString() {
        return "count: " + count + " from: " + from;
    }
}


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Reported> counts = new HashMap<>();

        for (String re: report) {
            String[] splited = re.split(" ");
            String from = splited[0];
            String to = splited[1];

            Reported r = counts.getOrDefault(to, new Reported(0, new HashSet<>()));
            boolean added = r.from.add(from); // HashSet.add()는 새로운 원소가 추가되면 true, 이미 있으면 false 반환
            if (added) counts.put(to, new Reported(r.count + 1, r.from));
        }
        // System.out.println(counts);

        Map<String, Integer> froms = new LinkedHashMap<>();
        for (String id: id_list) {
            froms.put(id, 0);
        }
        // System.out.println(froms);

        for (Reported r : counts.values()) {
            if (r.count < k) continue;
            for (String f : r.from) {
                froms.put(f, froms.get(f) + 1);
            }
        }

        return froms.values().stream().mapToInt(Integer::intValue).toArray();
    }
}