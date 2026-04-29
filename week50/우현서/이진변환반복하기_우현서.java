// 모든 0 제거후 길이를 2진법으로
// 1이 될때까지
// 변환 횟수, 제거된 0의 개수 구하기

// 정수를 2진법: Integer.toBinaryString

class Solution {
    public int[] solution(String s) {

        int count = 0;
        int count0 = 0;

        while (true) {
            if (s.equals("1")) break;
            count++;

            int count1 = 0;
            for (char c: s.toCharArray()) {
                if (c=='1') count1++;
                else count0++;
            }

            s = Integer.toBinaryString(count1);

        }


        return new int[]{count, count0};
    }
}