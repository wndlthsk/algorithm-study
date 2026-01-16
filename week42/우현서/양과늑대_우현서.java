// 이진 트리, 루트노드에서 출발, 각 노드 방문하면서 양 모으기
// 모은 양 수 <= 늑대 수 -> 양 잡아먹힘
// 중간에 잡아먹히지 않게 하면서 최대한 많은 양 모아서 다시 루트로 돌아오게
// info: 노드 정보, 0: 양/ 1: 늑대
// edges: 2진 트리 노드 연결 관계, [부모 노드 번호, 자식 노드 번호]
// 0번 노드(루트 노드)에는 항상 양

// 노드별 자식 노드 저장 -> List<List<Integer>> children
// 루트부터 재귀함수 돈다. 현재 노드에서 갈 수 있는 후보 노드 넘기면서

// Collection에서 addAll : newCandidate.addAll(children.get(next));

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int n = info.length;

        List<List<Integer>> children = new ArrayList<>();
        for (int i=0; i<n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] e: edges) {
            children.get(e[0]).add(e[1]);
        }

        Set<Integer> candidate = new HashSet<>();
        for (int x: children.get(0)) {
            candidate.add(x);
        }
        dfs(info, children, candidate, 1, 0);

        return max;
    }


    int max = 0;

    public void dfs(int[] info, List<List<Integer>> children, Set<Integer> candidate, int sheep, int wolf) {
        max = Math.max(max, sheep);

        for (int next: candidate) {
            Set<Integer> newCandidate = new HashSet<>(candidate);
            newCandidate.remove(next);
            newCandidate.addAll(children.get(next));

            if (info[next] == 0) { // 양
                dfs(info, children, newCandidate, sheep+1, wolf);
            } else { // 늑대
                if (sheep <= wolf + 1) continue;
                dfs(info, children, newCandidate, sheep, wolf+1);
            }
        }
    }
}
