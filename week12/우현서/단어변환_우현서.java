// begin에서 target으로 변환하는 최소 변환 단계 수 구하기
// 한번에 한 개의 알파벳만 바꿀 수 있음
// words에 있는 단어로만 변환 가능
// 각 단어는 소문자, 모든 단어의 길이는 같음, 중복 단어 없음, begin!=target
// 변환 불가인 경우 0을 리턴

import java.util.*;


class Step {
    private String word;
    private int count;

    public Step(String word, int count){
        this.word = word;
        this.count = count;
    }

    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int len = begin.length();

        Queue<Step> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Step(begin, 0)); // 현재 단계 시작 단어, 변환 단계 카운트
        visited.add(begin);

        while(!queue.isEmpty()) {
            // System.out.println("큐: "+queue);
            Step now = queue.poll();
            String nowWord = now.getWord();
            int nowCount = now.getCount();

            if (nowWord.equals(target)) return nowCount;

            for(String word: words) {
                if (!visited.contains(word)) {
                    char[] chars = word.toCharArray();
                    int count = 0; // 알파벳 다른 거 개수
                    for (int i=0; i<len; i++) {
                        if (count > 1) break;
                        if (word.charAt(i) != nowWord.charAt(i)) count ++;
                    }
                    if (count == 1) {
                        visited.add(word);
                        queue.add(new Step(word, nowCount+1));
                    }
                }
            }
        }
        return 0;
    }
}