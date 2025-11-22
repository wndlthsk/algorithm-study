package week36.우현서;// 연속 부분 수열에 같은 길이의 펄스 수열을 각 원소끼리 곱해서 연속 펄스 부분 수열
// 합이 가장 큰 것을 리턴


class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[] pulse1 = new int[n];
        int[] pulse2 = new int[n];
        int x = 1;
        for (int i=0; i<n; i++) {
            pulse1[i] = x * sequence[i];
            pulse2[i] = -1 * x * sequence[i];
            x *= -1;
        }
        // System.out.println(Arrays.toString(pulse1));
        // System.out.println(Arrays.toString(pulse2));

        long answer = Math.max(kadane(pulse1), kadane(pulse2));

        return answer;
    }

    public long kadane(int[] arr) {
        long cur = arr[0];
        long best = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            best = Math.max(best, cur);
        }
        return best;
    }
}