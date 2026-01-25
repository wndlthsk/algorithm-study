// A -> .. -> UUUUU
// 사전에서 몇번째 단어인지 리턴

// 781 / 156/ 31/ 6/1

class Solution {
    public int solution(String word) {
        int answer = 0;
        String vowels = "AEIOU";
        int[] cases = new int[]{781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            int idx = vowels.indexOf(word.charAt(i));
            answer += idx * cases[i] + 1;
        }

        return answer;
    }
}