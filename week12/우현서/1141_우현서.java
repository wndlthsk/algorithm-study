// 집합의 한 단어가 다른 단어의 접두어가 되지 않는 집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        // 방법1) 문자열의 글자수로 내림차순
        // 긴 문자열을 먼저 저장해두고, 다음 추가 단어가 기존에 선택된 단어들의 접두사인지 검사
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            if(set.isEmpty()) set.add(word);
            else {
                boolean check = true;
                for(String word2 : set) {
                    if(word2.indexOf(word) == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) set.add(word);
            }
        }
        System.out.println(set.size());

        // 방법2) 사전순 정렬
        // 사전순 정렬하면 접두사 관계가 있는 문자열은 항상 앞쪽에 위치함.
//        Arrays.sort(words);
//
//        int ans = 1;
//        for(int i=1; i<n; i++) {
//            String word1 = words[i-1], word2 = words[i];
//            if(word2.length() >= word1.length()) {
//                if(word2.startsWith(word1)) {
//                    continue;
//                }
//            }
//            ans++;
//        }
//        System.out.println(ans);
    }



}