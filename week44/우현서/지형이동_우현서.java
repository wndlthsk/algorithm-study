// nxn 격자, 각 칸에 숫자(그칸의 높이)
// 아무 칸에서 출발, 모든 칸 방문
// 4방향 이동, 현재 칸과 다음칸 높이차가 height이하여야함
// height보다 많으면 사다리 설치, 비용 += 두 격차 칸의 높이차
// 최소 비용으로 모든 칸 이동
// land : 격자칸의 높이
// height: 최대 높이 차
// 최소 비용 리턴

// 사다리 설치 비용 누적하면서 dfs
// 왜 안됨?????/
// 다익스트라도 될까? 설치할 필요없으면 0, 필요하면 += -> 될듯
// 다익스트라가 아니라 프림이다;;

// dfs는 방문 순서가 존재하기 때문에 최솟값을 못 찾는다. 이 문제는 "어떻게든 모든 칸이 서로 통하게만 만드는 방법"을 찾으면 됨
// 다익스트라는 출발지에서 모든 노드까지의 거리 구할때
// 이문제는 모든 칸을 연결하는 최소 비용을 구하는 거니까 프림을 써야함
// height 이하인 곳들을 섬으로 묶으면 섬 연결하기 문제랑 같아짐 ㄷㄷ..
// dfs와 차이점은 "지금 내 발밑뿐만 아니라, 내가 이미 가본 모든 땅의 경계선에서 가장 유리한 한 칸을 고른다"
// dfs는 한 번 방문한 칸은 다시 갈 수 없다. 막다른 길에 도착하면 왔던 길을 되돌아가서(backtrack) 다른 길을 찾아야함. 이 '되돌아가는 과정'에서는 새로운 연결을 만들지 못한다. 걍 새로운 순서를 시도해보는 것임


import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
    int n;

    public int solution(int[][] land, int height) {
        int answer = 0;
        n = land.length;


        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[n][n];

        pq.add(new int[]{0, 0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int totalCost = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0], y = now[1], cost = now[2];

            if (visited[x][y]) continue;
            visited[x][y] = true;
            totalCost += cost;

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(land[x][y] - land[nx][ny]);
                int nextCost = (diff <= height) ? 0 : diff;
                pq.add(new int[]{nx, ny, nextCost});
            }

        }

        return totalCost;
    }

}