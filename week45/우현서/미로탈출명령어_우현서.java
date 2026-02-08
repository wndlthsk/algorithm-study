// (x, y) -> (r, c)
// 이동거리 총 k, 같은 격자 두번 이상 방문 가능
// 문자열 사전순 가장 빠른 경로로 탈출
// 탈출 못하면 impossible 리턴
// 1-based

// dfs
// 현재 거리 누적하면서 k 넘으면 패스, k면 경로 후보에 추가
// -> 후보에 저장할 필요 없다. 4방향 접근할 때 사전순으로 접근하게하고, 처음 찾은 게 답이다
// + 가지치기를 잘해야함

// StringBuilder에서 원소 삭제
// sb.deleteCharAt(sb.length() - 1);

class Solution {
    int N, M, R, C, K;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;

        dfs(x, y, 0, new StringBuilder());

        return found ? result : "impossible";
    }

    String result = "";
    boolean found = false;

    char[] dir = {'d', 'l', 'r', 'u'}; // 사전순으로 접근하도록
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};

    public void dfs(int x, int y, int count, StringBuilder sb) {
        if (found) return;
        if (count > K) return;

        int dist = Math.abs(x - R) + Math.abs(y - C); // 목표 좌표까지 최소 이동 거리
        if (dist + count > K) return; // K로 못가는 경우 리턴
        if ((K - count - dist) % 2 != 0) return; // (남은 이동 수 - 최소 필요 이동 수)가 홀수면 불가능 (왕복 못 갔다 오니까)

        if (count == K && x == R && y == C) {
            result = sb.toString();
            found = true;
            return;
        }

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 1 || nx > N || ny < 1 || ny > M) continue;

            sb.append(dir[d]);
            dfs(nx, ny, count+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}