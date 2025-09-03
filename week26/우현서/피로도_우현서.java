// 최소 필요 피로도: 던전 탐험을 위해 가지고 있어야하는 최소한의 피로도
// 소모 피로도: 던전 탐험 후 소모되는 피로도
// 하루에 한번식 탐험하는 던전들
// 탐험할 수 있는 최대 던전 수 리턴
// k: 현재 피로도, dungeons: 최소, 소모

// 탐험 or 탐험 x 해보면서 던전 수 카운트 갱신

class Solution {
    int n;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        backtrack(dungeons, k, 0);

        return result;
    }

    int result = 0;

    public void backtrack(int[][] dungeons, int now, int count) {
        result = Math.max(result, count);

        for (int i=0; i<n; i++) {
            if (!visited[i] && dungeons[i][0] <= now) {
                visited[i] = true;
                backtrack(dungeons, now-dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}