// a,e,i,o,u
// a, aa, .. -> uuuuu
// 단어가 사전에서 몇번째인지 리턴

// a____ : 5*5*5*5 = 625
// a___ : 5*5*5 = 125
// a__ : 5*5 = 25
// a_ : 5
// a: 1
// = 781
// 각 자리수에서 뛰어넘을 수 있는 개수: 781, 156, 31, 6, 1

class Solution {

    public int solution(String word) {

        dfs(word, new StringBuilder());

        return answer;
    }

    char[] vowels = {'A', 'E', 'I', 'O', 'U'};;

    int answer = 0;
    int count = 0;

    private void dfs(String word, StringBuilder sb) {
        if (sb.length() > 0) {
            count++; // 순서 카운트

            if (sb.toString().equals(word)) { // 단어 찾으면 종료
                answer = count;
                return;
            }

            if (sb.length() == 5) return;
        }


        for (int i=0; i<5; i++) {
            sb.append(vowels[i]);

            dfs(word, sb);

            sb.deleteCharAt(sb.length()-1);
        }
    }
}