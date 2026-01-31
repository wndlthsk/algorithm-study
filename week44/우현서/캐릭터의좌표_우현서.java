// 0,0에서 시작, 마지막 캐릭터의 좌표 리턴

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Map<String, Integer> dir = new HashMap<>();
        dir.put("up", 0);
        dir.put("down", 1);
        dir.put("left", 2);
        dir.put("right", 3);

        int x = 0;
        int y = 0;
        int minX = -1 * (board[0] / 2);
        int maxX = board[0] / 2;
        int minY = -1 * (board[1] / 2);
        int maxY = board[1] / 2;
        for (String k: keyinput) {
            int nx = x + dx[dir.get(k)];
            int ny = y + dy[dir.get(k)];

            if (nx < minX || nx > maxX || ny < minY || ny > maxY) continue;
            x = nx;
            y = ny;
        }

        return new int[]{x, y};
    }
}