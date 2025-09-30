// 모은 양의 수보다 늑대 수가 같거나 많아지면 모든 양 먹음
// 최대한 많은 양을 모아 다시 루트로 돌아오게
// info: 각 노드의 양/늑대, 0: 양/ 1: 늑대
// edges: 각 노드 연결 관계

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> adjList;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        adjList = new ArrayList<>();
        for (int i=0; i<info.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            adjList.get(a).add(b);
        }
        // System.out.println(adjList);

        Set<Integer> candidate = new HashSet<>();
        candidate.add(0);
        dfs(info, 0, 1, 0, candidate);

        // System.out.println(result);
        return result;
    }

    int result = 0;
    public void dfs(int[] info, int node, int sheep, int wolf, Set<Integer> candidate) {
        if (sheep == wolf) return;
        else result = Math.max(result, sheep);

        Set<Integer> newCandidate = new HashSet<>(candidate);
        newCandidate.remove(node);
        newCandidate.addAll(adjList.get(node));

        for (int next: newCandidate) {
            if (info[next] == 0)
                dfs(info, next, sheep+1, wolf, newCandidate);
            else if (info[next] == 1)
                dfs(info, next, sheep, wolf+1, newCandidate);
        }
    }
}