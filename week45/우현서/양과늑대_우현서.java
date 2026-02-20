// 현재 양/늑대 개수 가지고 dfs
// 현재 노드의 자식만 하는 게 아니라 candidates를 관리해줘야함

import java.util.ArrayList;
import java.util.List;
class Solution {
    List<List<Integer>> children;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        children = new ArrayList<>();
        for (int i=0; i<info.length; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            children.get(edge[0]).add(edge[1]);
        }
        // System.out.println(children);

        List<Integer> candidates = new ArrayList<>(children.get(0));
        dfs(info, candidates, 1, 0);

        return result;
    }

    int result = 0;

    public void dfs(int[] info, List<Integer> candidates, int sheep, int wolf) {
        if (sheep <= wolf) {
            return;
        }
        result = Math.max(result, sheep);

        for (int next: candidates) {
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(Integer.valueOf(next));
            nextCandidates.addAll(children.get(next));

            if (info[next] == 0) dfs(info, nextCandidates, sheep+1, wolf);
            else dfs(info, nextCandidates, sheep, wolf+1);
        }
    }
}