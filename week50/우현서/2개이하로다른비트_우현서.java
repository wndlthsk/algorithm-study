// 짝수면 마지막을 1로 바꿈
// 홀수면 오른쪽에서 먼저 나오는 0을 1로 바꾸고 그 오른쪽 거를 0으로 바꿈

class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];


        for (int i=0; i<n; i++) {
            long num = numbers[i];

            if (num % 2 == 0) {
                answer[i] = num+1;
            } else {
                String bit = "0" + Long.toBinaryString(num);
                char[] chars = bit.toCharArray();

                for (int j=chars.length-1; j>0; j--) {
                    if (chars[j]=='1' && chars[j-1]=='0') {
                        chars[j] = '0';
                        chars[j-1] = '1';
                        break;
                    }
                }

                answer [i] = Long.parseLong(new String(chars), 2);
            }
        }

        return answer;
    }
}