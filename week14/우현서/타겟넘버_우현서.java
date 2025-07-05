// n개의 음이 아닌 정수들
// 순서 안바꾸고 더하거나 빼서 타겟 넘버 만드는 방법의 수를 리턴

// 각 정수들에 +, - 붙여보기? 그럼 2**numbers수, 최대 2**20 = 약 100만으로 시간복잡도 괜찮음

import java.util.*;

class Solution {
    int result = 0;

    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        // bfs(0, numbers, target);

        return result;
    }

    public void dfs(int idx, int sum, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (sum == target) result++;
            return;
        }

        dfs(idx + 1, sum + numbers[idx], numbers, target); // + 붙이기
        dfs(idx + 1, sum - numbers[idx], numbers, target); // - 붙이기
    }

    public void bfs(int x, int[] numbers, int target) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int idx = now[0];
            int sum = now[1];

            if (idx == numbers.length) {
                if (sum == target) result++;
                continue;
            }

            queue.add(new int[]{idx+1, sum + numbers[idx]});
            queue.add(new int[]{idx+1, sum - numbers[idx]});
        }
    }
}