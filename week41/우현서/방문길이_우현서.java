// u,d,r,l 방향
// 0,0에서 시작 -> (5, 5)
// 10*10
// 왼쪽 위(-5, 5) -> (0,0)
// 왼쪽 아래(-5, -5) -> (10,0)
// 오른쪽 위(5, 5) -> (0, 10)
// 오른쪽 아래(5, -5) -> (10,10)
// x+5 -> 열 / |y-5| -> 행
// 좌표평면의 경계를 넘어가는 명령어는 무시

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int solution(String dirs) {
        Set<String> passed = new HashSet<>();
        int cnt = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Map<Character, Integer> direction = new HashMap<>();
        direction.put('U', 0);
        direction.put('D', 1);
        direction.put('R', 2);
        direction.put('L', 3);

        int r = 5;
        int c = 5;
        for (char d: dirs.toCharArray()) {
            int nr = r + dx[direction.get(d)];
            int nc = c + dy[direction.get(d)];
            if (nr < 0 || nr >= 11 || nc < 0 || nc >= 11) continue;

            // 좌표 문자열
            String rc1 = r + "," + c + "->" + nr + "," + nc;
            String rc2 = nr + "," + nc + "->" + r + "," + c;

            if (!passed.contains(rc1) && !passed.contains(rc2)) cnt++;
            passed.add(rc1);
            passed.add(rc2);

            // 현재 위치 갱신
            r = nr;
            c = nc;
        }

        return cnt;
    }

}