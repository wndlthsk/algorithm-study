// 1~n번호, n명
// 번호 순대로 / 마지막 -> 1번 / 앞사람의 마지막 문자로 시작하는 단어 / 등장했던 건 사용 불가 / 한글자는 인정x
// 가장 먼저 탈락하는 사람의 번호, 자신의 몇번째 차례에서 탈락하는지 리턴
// 탈락자 없으면 0, 0

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);

        boolean flag = true;
        int x = 0;
        for (int i=1; i<words.length; i++) {
            String word = words[i];

            char first = word.charAt(0);
            if (last != first) {
                flag = false;
                x = i;
                break;
            }

            if (wordSet.contains(word)) {
                flag = false;
                x = i;
                break;
            }

            if (word.length() <= 1) {
                flag = false;
                x = i;
                break;
            }

            last = word.charAt(word.length()-1);
            wordSet.add(word);
        }

        if (!flag) return new int[]{x%n + 1,  (x+1 + n-1) / n };
        else return new int[]{0,0};
    }
}