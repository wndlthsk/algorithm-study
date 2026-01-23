// 탐험 시작을 위해 필요한 최소 필요 필요도, 탐험 후 소모되는 소모 필요도
// 탐험할 수 있는 최대 던전 수 리턴

class Solution {
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(dungeons, k, visited, 0);

        return max;
    }

    int max = Integer.MIN_VALUE;

    public void backtrack(int[][] dungeons, int tiredness, boolean[] visited, int count) {
        max = Math.max(max, count);

        for (int i=0; i<dungeons.length; i++) {
            if(visited[i]) continue;
            if (tiredness < dungeons[i][0]) continue;

            visited[i] = true;
            backtrack(dungeons, tiredness - dungeons[i][1], visited, count+1);
            visited[i] = false;
        }
    }
}