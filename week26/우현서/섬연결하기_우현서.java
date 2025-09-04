// costs: 섬 연결 비용
// 모든 섬이 통행 가능하도록 하는 최소 비용 리턴
// 여러번 건너서 도달해도 됨

// 최소 신장 트리?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "(" + to+ ", " + cost + ")";
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost; // 오름차순
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] cost: costs) {
            adjList.get(cost[0]).add(new Node(cost[1], cost[2]));
            adjList.get(cost[1]).add(new Node(cost[0], cost[2]));
        }
        System.out.println(adjList);
        answer = getMstCost(n, adjList);

        return answer;
    }

    public int getMstCost(int n, List<List<Node>> adjList) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] isSelected = new boolean[n];
        int[] minEdge = new int[n];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        minEdge[0] = 0;
        pq.add(new Node(0, 0));

        int sum = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int minIdx = now.to;
            if(isSelected[minIdx]) continue;

            //2. minIdx정점을 트리에 포함시키기
            isSelected[minIdx] = true;
            sum += minEdge[minIdx];
            cnt++;
            if(cnt == n) return sum;

            //3. minIdx정점과 인접한 정점(to)에 대한 최소 비용 갱신
            for(Node next : adjList.get(minIdx)) {
                int to = next.to;
                int cost = next.cost;

                if(isSelected[to]) continue;
                if(minEdge[to] <= cost) continue;

                minEdge[to] = cost;
                pq.add(next);
            }
        }

        return -1;
    }
}