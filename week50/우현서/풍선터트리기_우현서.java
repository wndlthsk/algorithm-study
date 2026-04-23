package week50.우현서;// 인접 풍선 중 하나 터트림
// 빈공간 생기면 중앙으로 밀착
// 번호 작은 건 최대 한번만 터트릴 수 있음
// 최후 풍선 개수

// 현재 숫자 기준 양쪽에 더 작은 숫자가 있는지 확인
// 있으면 살아남을 수 없음

class Solution {
    public int solution(int[] a) {
        int answer = 0;

        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            min = Math.min(min, a[i]);
            leftMin[i] = min;
        }

        min = Integer.MAX_VALUE;
        for (int i=n-1; i>=0; i--) {
            min = Math.min(min, a[i]);
            rightMin[i] = min;
        }

        // System.out.println(Arrays.toString(leftMin));
        // System.out.println(Arrays.toString(rightMin));


        for (int i=0; i<n; i++) {
            int left = leftMin[i];
            int right = rightMin[i];

            if (left < a[i] && right < a[i]) continue;
            answer++;
        }

        return answer;
    }
}