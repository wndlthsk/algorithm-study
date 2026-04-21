// 중요 단어가 몇개인지
//

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {

        char[] chars = message.toCharArray();
        for (int[] r: spoiler_ranges) {
            for (int i=r[0]; i<=r[1]; i++) {
                if (chars[i] == ' ') continue;
                chars[i] = '*';
            }
        }
        // System.out.println(Arrays.toString(chars));

        String str = new String(chars);
        // System.out.println(str);

        String[] splited_ori = message.split(" ");
        String[] splited = str.split(" ");
        // System.out.println(Arrays.toString(splited));

        Set<String> words = new HashSet<>();
        for (String s: splited) {
            if (s.contains("*")) continue;
            words.add(s);
        }
        // System.out.println(words);


        int answer = 0;

        for (int i=0; i<splited.length; i++) {
            String s = splited[i];
            if (!s.contains("*")) continue;

            if (!words.contains(splited_ori[i])) {
                // System.out.println(splited_ori[i]);
                answer++;
                words.add(splited_ori[i]);
            }
        }
        // System.out.println(words);



        return answer;
    }
}