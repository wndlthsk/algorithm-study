import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    int ticketCount;

    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;

        Map<String, List<String>> adjMap = new HashMap<>();
        for (String[] ticket: tickets) {
            List<String> list = adjMap.getOrDefault(ticket[0], new ArrayList<>());
            list.add(ticket[1]);
            adjMap.put(ticket[0], list);
        }
        // System.out.println(adjMap);

        for (List<String> list : adjMap.values()) {
            Collections.sort(list);
        }

        path.add("ICN");
        dfs(adjMap, "ICN");
        // System.out.println(path);

        String[] answer = new String[path.size()];
        for (int i=0; i<path.size(); i++) {
            answer[i] = path.get(i);
        }

        return answer;
    }


    List<String> path = new ArrayList<>();
    boolean found = false;

    public void dfs(Map<String, List<String>> adjMap, String now) {
        if (path.size() == ticketCount+1) {
            found = true;
            return;
        }

        if (!adjMap.containsKey(now)) return;

        List<String> list = adjMap.get(now);

        for (int i = 0; i < list.size(); i++) {
            String next = list.get(i);
            if (next.equals("")) continue;

            list.set(i, "");
            path.add(next);
            dfs(adjMap, next);
            if (found) return;
            path.remove(path.size() - 1);
            list.set(i, next);
        }
    }
}