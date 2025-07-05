import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // tangerine[i]의 최대값을 찾음
        int max = 0;
        for (int i = 0; i < tangerine.length; i++) {
            if (tangerine[i] > max) {
                max = tangerine[i];
            }
        }

        int[] arr = new int[max + 1]; // 정확한 크기로 설정

        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]] += 1;
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            k -= arr[i];
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
