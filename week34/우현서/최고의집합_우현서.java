// 최고의 집합: 각 원소의 합이 s && 각 원소의 곱이 최대가 되는 집합
// 오름차순 정렬
// 존재하지 않으면 [-1] 리턴
// n: 원소의 개수
// s: 집합 원소의 합

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int base = s / n;
        int remainder = s % n;

        int[] result = new int[n];
        Arrays.fill(result, base);

        for (int i = 0; i < remainder; i++) {
            result[n - 1 - i] += 1;
        }

        return result;
    }
}