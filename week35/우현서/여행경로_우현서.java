// 모든 항공권 사용해서 여행 경로 짜기
// tickets: 항공권 정보 [a, b] a에서 b공항
// 방문하는 공항 경로 리턴

// 가능한 경로가 2개 이상인 경우 알파벳 순서

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Ticket {
    String from;
    String to;

    public Ticket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(from, ticket.from) &&
            Objects.equals(to, ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ")";
    }
}

class Solution {
    Map<Ticket, Integer> ticketCountMap;
    Map<String, List<String>> adjList;

    public String[] solution(String[][] tickets) {
        int count = tickets.length;
        ticketCountMap = new HashMap<>();
        adjList = new HashMap<>();

        for (String[] t: tickets) {
            Ticket ticket = new Ticket(t[0], t[1]);
            ticketCountMap.put(ticket, ticketCountMap.getOrDefault(ticket, 0) + 1);

            adjList.computeIfAbsent(t[0], k -> new ArrayList<>()).add(t[1]);
        }
        // System.out.println(ticketCountMap);
        // System.out.println(adjList);

        for (List<String> airports : adjList.values()) {
            Collections.sort(airports);
        }
        // System.out.println(adjList);

        List<String> route = new ArrayList<>();
        route.add("ICN");
        dfs("ICN", count, route);
        // System.out.println(answerRoute);

        String[] answer = new String[answerRoute.size()];
        for (int i=0; i<answerRoute.size(); i++) {
            answer[i] = answerRoute.get(i);
        }

        return answer;
    }

    List<String> answerRoute;
    boolean isFound = false;

    public void dfs(String now, int count, List<String> route) {
        if (isFound) return;

        if (count == 0) {
            isFound = true;
            answerRoute = new ArrayList<>(route);
            return;
        }

        for (String next: adjList.getOrDefault(now, Collections.emptyList())) {
            Ticket ticket = new Ticket(now, next);
            if (ticketCountMap.get(ticket) <= 0) continue;

            ticketCountMap.put(ticket, ticketCountMap.get(ticket) - 1);
            route.add(next);
            dfs(next, count-1, route);
            route.remove(route.size()-1);
            ticketCountMap.put(ticket, ticketCountMap.get(ticket) + 1);
        }
    }
}