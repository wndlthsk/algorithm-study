// 홀짝트리되는 개수와 역홀짝 트리되는 개수를 리턴

// 인접리스트 만들어거 각 노드를 루트노드로 가정해서 그래프 확인하기
// root -> 자식 수: degree(간선 수)
// root아닌 노드 -> 자식 수: degree-1

// 홀짝 트리
// 루트: 번호 홀짝 == degree 홀짝
// 루트 제외: 번호 홀짝 != degree 홀짝

// 역홀짝 트리
// 루트: 번호 홀짝 != degree 홀짝
// 루트 제외: 번호 홀짝 == degree 홀짝

// 각 트리에서 (번호 홀짝 == degree 홀짝) 이 경우가 하나면 홀짝트리++
// (번호 홀짝 != degree 홀짝) 이 경우가 하나면 역홀짝 트리++

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int n: nodes) {
            adjMap.put(n, new ArrayList<>());
        }
        for (int[] e: edges) {
            adjMap.get(e[0]).add(e[1]);
            adjMap.get(e[1]).add(e[0]);
        }
        // System.out.println(adjMap);

        Set<Integer> visited = new HashSet<>();

        for (int node: nodes) {
            if (visited.contains(node)) continue;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(node);
            visited.add(node);

            int sameCount = 0;
            int diffCount = 0;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                int degree = adjMap.get(now).size();

                if (now % 2 == degree % 2) sameCount++; // 홀짝트리
                else diffCount++; // 역홀짝트리

                for (int next: adjMap.get(now)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.offer(next);
                }
            }

            if (sameCount == 1) answer[0]++;
            if (diffCount == 1) answer[1]++;

        }

        return answer;
    }
}