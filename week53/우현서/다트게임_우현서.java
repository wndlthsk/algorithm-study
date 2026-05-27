// 스타상 -> 2배, 아차상 -> 마이너스
// 스타상 + 아차상 -> -2배
// 총점수 리턴
// 점수|보너스(S,D,T)|[옵션](*,#)

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] chars = dartResult.toCharArray();

        int score = 0;
        int before = 0;

        for (int i=0; i<chars.length; i++) {
            char c = chars[i];

            switch (c) {
                case 'S':
                    break;

                case 'D':
                    score = score * score;
                    break;

                case 'T':
                    score = score * score * score;
                    break;

                case '*':
                    answer += before;
                    score *= 2;
                    break;

                case '#':
                    score = -score;
                    break;

                default:
                    answer += score;
                    before = score;

                    if (i + 1 < chars.length && c == '1' && chars[i + 1] == '0') {
                        score = 10;
                        i++;
                    } else {
                        score = c - '0';
                    }
            }
        }

        return answer + score;
    }
}