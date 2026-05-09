import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> countMap = new HashMap<>();

        char[][] types = {
            {'R', 'T'},
            {'C', 'F'},
            {'J', 'M'},
            {'A', 'N'}
        };

        for (char[] t: types) {
            countMap.put(t[0], 0);
            countMap.put(t[1], 0);
        }



        int N = survey.length;

        for (int i=0; i<N; i++) {
            String s = survey[i];
            int choice = choices[i];
            char[] type = s.toCharArray();

            if (choice <= 3) { // 앞에거 비동의
                countMap.put(type[0], countMap.get(type[0]) + (4-choice));
            } else if (choice >= 5) {
                countMap.put(type[1], countMap.get(type[1]) + (choice-4));
            }

        }
        // System.out.println(countMap);

        StringBuilder sb = new StringBuilder();

        for (char[] t: types) {
            if (countMap.get(t[0]) >= countMap.get(t[1])) sb.append(t[0]);
            else sb.append(t[1]);
        }



        return sb.toString();
    }
}