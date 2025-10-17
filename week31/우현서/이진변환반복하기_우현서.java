package week31.우현서;

class Solution {
    public int[] solution(String s) {
        int countChange = 0;
        int countZero = 0;

        while(true) {
            if (s.equals("1")) break;

            for (char c: s.toCharArray()) {
                if (c == '0') {
                    countZero++;
                }
            }

            s = s.replace("0", "");
            int c = s.length();
            s = Integer.toBinaryString(c);
            countChange++;
        }

        return new int[]{countChange, countZero};
    }
}