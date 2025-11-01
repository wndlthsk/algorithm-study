// 경주로 부지 nxn
// 0: 빈 칸/ 1: 벽
// 경주로 출발 : (0,0) / 도착 : (n-1,n-1)
// 출발지에서 도착지까지 끊기지 않도록 경주로 건설
// 4방향 인접한 두 빈칸을 연결해 건설할 수 있다.
// 상하/좌우로 연결한 경주로 : 직선도로 -> 100원
// 두 직선 도로가 서로 직각으로 만나는 지점 : 코너 -> 500원
// 최소 비용 계산하기

// 코너 개수는 이전 도로 방향이랑 다르면 카운트

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
    int x;
    int y;
    int cost;
    int direction;

    public Node(int x, int y, int cost, int direction) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
    }
}

class Solution {
    int n;

    public int solution(int[][] board) {
        n = board.length;
        int answer = dijkstra(board);

        return answer;
    }

    public int dijkstra(int[][] board) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[][][] visited = new boolean[n][n][2];
        int[][][] cost = new int[n][n][2]; // 방향에 따른 최솟값 저장할 변수

        pq.add(new Node(0, 0, 0, 0)); // x, y, 금액, 상하(0)/좌우(1)
        pq.add(new Node(0, 0, 0, 1));
        for (int[][] co: cost) {
            for (int[] c: co) {
                Arrays.fill(c, Integer.MAX_VALUE);
            }
        }
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;
            int nowCost = now.cost;
            int nowDirection = now.direction;

            if (x == n-1 && y == n-1) {
                return nowCost;
            }

            if (visited[x][y][nowDirection]) continue;
            visited[x][y][nowDirection] = true;

            for (int d=0; d<4; d++) {
                int newDirection = (d < 2) ? 0 : 1;
                boolean isCorner = (nowDirection != newDirection ) ? true : false;

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] == 1) continue;

                int newPrice = 100 + (isCorner ? 500 : 0);
                if (cost[nx][ny][newDirection] <= nowCost + newPrice) continue;

                cost[nx][ny][newDirection] = nowCost + newPrice;
                pq.add(new Node(nx, ny, cost[nx][ny][newDirection], newDirection));
            }
        }

        return -1;
    }
}