// a,e,i,o,u 만 사용해서 길이 5 이하의 단어
// word가 몇번째 단어인지 리턴

// 한 문자당 몇번까지 있는지 & 각 문자 개수마다 몇개 있는지 찾긴

class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] splited = word.split("");

        // 첫글자가 A면, 뒤에 올 수 있는 경우의 수
        // 뒤에 0~4개를 붙일 수 있음 = 5^0 + 5^1 + 5^2 + 5^3 + 5^4
        int first = 1 + 5 + 25 + 125 + 625;
        int second = 1 + 5 + 25 + 125;
        int third = 1 + 5 + 25;
        int fourth = 1 + 5;
        int fifth = 1;
        int[] skip = {first, second, third, fourth, fifth};

        String vowel = "AEIOU";
        for (int i=0; i<word.length(); i++) {
            int idx = vowel.indexOf(splited[i]);
            answer += idx * skip[i] + 1;
        }

        return answer;
    }
}