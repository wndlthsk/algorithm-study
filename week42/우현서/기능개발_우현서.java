// 기능 개선 작업, 각 기능은 진도가 100일때 반영 가능
// 각 기능의 개발 속도는 다 다름, 뒤에 있는 기능은 앞 기능 배포될때 함께 배포
// progresses: 먼저 배포돼야하는 순서대로 작업 진도 배열
// speeds: 각 작업의 개발 속도 배열
// 각 배포마다 몇개 기능이 배포되는지 리턴

// 필요한 일수를 큐에 넣고, 앞에부터 꺼내는데 뒤에가 앞보다 적으면 더 꺼냄

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 큐 사용
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i=0; i<progresses.length; i++) {
            int leftProgress = 100 - progresses[i];
            int x = (leftProgress % speeds[i] == 0) ? leftProgress/speeds[i] : leftProgress/speeds[i] + 1;
            queue.add(x);
        }
        // System.out.println(queue);

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        while (!queue.isEmpty()) {
            int before = queue.poll();
            cnt++;
            while (!queue.isEmpty() && queue.peek() <= before) {
                queue.poll();
                cnt++;
            }
            result.add(cnt);
            cnt = 0;
        }
        // System.out.println(result);

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}


// 큐 안쓴 버전
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        int day = 0;
        int cnt = 0;
        for (int i=0; i<progresses.length; i++) {
            int x = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if (x <= day) { // 현재 날짜에서 배포가능한 경우
                cnt++;
            } else { // 현재 날짜에서 배포 불가능하면
                // 이전 배포 개수 확정
                if (cnt > 0) result.add(cnt);
                // 현재 날짜, 개수 갱신
                day = x;
                cnt = 1;
            }
        }
        // 마지막 배포 처리
        result.add(cnt);

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}