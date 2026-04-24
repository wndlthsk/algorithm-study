//

class Solution {
    public int[] solution(int n, long left, long right) {

        int size = (int)(right - left) + 1;
        int[] answer = new int[size];

        int idx=0;
        for (long i=left; i<=right; i++) {
            long x = i/n;
            long y = i%n;

            answer[idx] = (int)Math.max(x, y) + 1;
            idx++;
        }


        return answer;
    }
}