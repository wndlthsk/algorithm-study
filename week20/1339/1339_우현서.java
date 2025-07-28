// 단어 수학 문제: n개의 단어로 이루어져있다.
// 각 단어는 알파벳 대문자로만 이루어져있다.
// 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 n개의 수를 합하는 문제이다.
// 같은 알파벳은 같은 숫자, 알파벳마다 다른 숫자여야한다.
// n개의 단어의 합의 최댓값 출력
// 1 <= n <= 10, 각 단어에 포함된 알파벳 <= 10, 수의 최대 길이는 8

// 1. 각 알파벳의 자리에 따라 가중치를 구한다. hashmap
// 2. 저 hashmap을 내림차순 정렬해서 9부터 할당한다.
// 3. 알파벳별 숫자를 보고 원래 단어를 숫자로 변환해서 합을 구한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
//        System.out.println(Arrays.toString(words));

        // 가중치 계산
        Map<Character, Integer> scores = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);
                int power = (int) Math.pow(10, len-j-1);
                scores.put(c, scores.getOrDefault(c, 0) + power);
            }
        }
//        System.out.println(scores);

        // Map 내림차순 정렬
        List<Map.Entry<Character, Integer>> scoreList = new ArrayList<>(scores.entrySet());
        scoreList.sort((a, b) -> b.getValue() - a.getValue());
//        System.out.println(scoreList);

        // 알파벳별 숫자 결정
        Map<Character, Integer> alphaNum = new HashMap<>();
        int num = 9;
        for (Map.Entry<Character, Integer> entry : scoreList) {
            alphaNum.put(entry.getKey(), num);
            num--;
        }
//        System.out.println(alphaNum);

        // 단어 -> 숫자
        int sum = 0;
        for (String word: words) {
            int result = 0;
            for (int i=0; i<word.length(); i++) {
                result *= 10; // 자릿수 올리는 역할
                result += alphaNum.get(word.charAt(i));
            }
            sum += result;
        }
        System.out.println(sum);
    }
}