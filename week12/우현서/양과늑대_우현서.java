// 2진 트리 각 노드에 늑대 or 양
// 루트 노드(양)에서 출발해서 양 최대로 모으는 게 목표
// 이때 모은 동물이 늑대 >= 양이면 양 다 잡아먹음

import java.util.*;

class Solution {
    List<Integer>[] tree;
    int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        // 간접리스트 -> 인접리스트
        int n = info.length;
        tree = new ArrayList[n];
        for (int i=0; i<n; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            tree[edge[0]].add(edge[1]);
        }

        // 후보 노드들
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        dfs(0, 0, 0, candidates, info);

        return maxSheep;
    }

    private void dfs(int node, int sheep, int wolf, List<Integer> candidates, int[] info) {
        if (info[node] == 0) sheep++;
        else wolf++;

        // 늑대가 같거나 많아지면 이동 멈춤
        if (wolf >= sheep) return;

        maxSheep = Math.max(maxSheep, sheep);

        // 현재 노드는 후보에서 지우고, 현재 노드의 자식을 후보에 등록
        // 지금까지 이동해온 경로에서 이동 가능한 노드 후보 리스트
        List<Integer> newCandidates = new ArrayList<>(candidates);
        newCandidates.remove(Integer.valueOf(node));
        newCandidates.addAll(tree[node]);

        // 후보 중 하나씩 dfs 돌면서 maxSheep 갱신
        for (int next: newCandidates) {
            dfs(next, sheep, wolf, newCandidates, info);
        }

    }
}