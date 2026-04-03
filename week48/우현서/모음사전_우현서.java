// A -> .. -> UUUUU
// 사전에서 몇번째 단어인지
// 781 156 31 6 1

class Solution {
    public int solution(String word) {
        int answer = 0;
        String str = "AEIOU";
        int[] orders = new int[]{781, 156, 31, 6, 1};
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            int idx = str.indexOf(chars[i]);
            answer += idx * orders[i] + 1;
        }

        return answer;
    }
}