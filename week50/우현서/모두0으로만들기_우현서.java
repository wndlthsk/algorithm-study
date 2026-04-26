// 트리의 모든 점들의 가중치를 0으로 만들게
// 두점 골라서 +1 / -1
// 가능하면 최소 횟수, 불가능하면 -1 리턴

// 자식 트리의 가중치 합 + 부모의 가중치 == 0 이면 가능
// 후위 순회 -> 왼 + 오 + 부모 == 0

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> adjList;
    static int[][] edges;
    static int[] a;

    public long solution(int[] a, int[][] edges) {
        this.edges = edges;
        this.a = a;

        int n = a.length;

        long sum = 0;
        for (int x: a) {
            sum += x;
        }
        if (sum != 0) return -1;

        adjList = new ArrayList<>(n); // 런타임 에러 때문에 크기 고정...
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e: edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }




        sum = dfs(0, -1);
        // System.out.println(sum);
        // System.out.println(cost);

        return cost;
    }


    long cost = 0;



    private long dfs(int node, int parent) { // 내 값 + 내 자식 값 리턴
        long sum = a[node];

        for (int i=0; i<adjList.get(node).size(); i++) {
            int child = adjList.get(node).get(i);
            if (child == parent) continue;
            sum += dfs(child, node);
        }

        cost += Math.abs(sum);

        return sum;
    }
}