// 연속된 구간 탐색, 단조 증가/감소일 땐 투포인터를 떠올리자
// 이중 for문이면 투포인터 or 슬라이딩 윈도우를 시도하자

class Solution {
    public int solution(int n) {
        int answer = 0;

        // 3. 투포인터
        int left = 1;
        int right = 1;
        int sum = 1;
        while(left <= right) {
            // System.out.println("l: " + left + " r: " + right + " s: " + sum );
            if (sum == n) {
                answer++;
                sum -= left;
                left++;
            } else if (sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }

        // 1. dfs
        // for (int i=1; i<=n; i++) {
        //     dfs(n, 0, i);
        // }
        // // System.out.println(count);
        // answer = count;

        // 2. 구현
        // for (int i=1; i<=n; i++) {
        //     int sum = 0;
        //     for (int j=i; j<=n; j++) {
        //         sum += j;
        //         if (sum == n) {
        //             answer++;
        //         }
        //         if (sum > n) {
        //             break;
        //         }
        //     }
        // }
        return answer;
    }

    int count = 0;

    public void dfs(int n, int sum, int num) {
        if (sum == n) {
            count++;
            return;
        }

        if (sum > n) {
            return;
        }

        dfs(n, sum + num, num + 1);
    }
}