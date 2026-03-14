// 순서 그대로 더하거나 빼서 만듦
// 타겟넘버 만드는 방법 수 리턴

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, 0, target);

        return count;
    }

    int count = 0;

    public void dfs(int[] numbers, int idx, int now, int target) {
        if (idx == numbers.length) {
            if (now == target) count++;
            return;
        }

        dfs(numbers, idx+1, now+numbers[idx], target);
        dfs(numbers, idx+1, now-numbers[idx], target);
    }
}