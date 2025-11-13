// n개의 음이 아닌 정수, 순서 안바꾸고 더하거나 빼서 타겟 넘버 만들기
// numbers: 사용 가능한 숫자
// target: 타겟 넘버
// 타겟 넘버 만드는 방법의 수 리턴

// 각 숫자에 +/- 붙였다 떼면서 백트래킹?

class Solution {
    int n;

    public int solution(int[] numbers, int target) {
        n = numbers.length;

        dfs(numbers, target, 0, 0);

        return result;
    }

    int result = 0;

    public void dfs(int[] numbers, int target, int i, int sum) {
        if (i == n && sum == target) {
            result++;
            return;
        }

        if (i >= n) return;

        dfs(numbers, target, i+1, sum + numbers[i]);
        dfs(numbers, target, i+1, sum - numbers[i]);

    }
}