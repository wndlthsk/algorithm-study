// 0,1로 이루어진 문자열
// 모든 0 제거, 문자열 길이를 2진법으로

class Solution {
    public int[] solution(String s) {
        int changeCount = 0;
        int count0 = 0;

        while (!s.equals("1")) {
            changeCount++;

            int count1 = 0;
            for (char c: s.toCharArray()) {
                if (c == '1') count1++;
                else count0++;
            }

            s = Integer.toBinaryString(count1);
        }


        return new int[]{changeCount, count0};
    }
}