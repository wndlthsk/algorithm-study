import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Integer> scores = new HashMap<>();
        for (String word : words) {
            int weight = 1;
            for (int i=word.length()-1; i>=0; i--) {
                char c = word.charAt(i);
                scores.put(c, scores.getOrDefault(c, 0) + weight);
                weight *= 10;
            }
        }

        List<Entry<Character, Integer>> list = new ArrayList<>(scores.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
//        System.out.println(list);

        Map<Character, Integer> alphaNum = new HashMap<>();
        int num = 9;
        for (Entry<Character, Integer> entry : list) {
            char c = entry.getKey();
            alphaNum.put(c, num);
            num--;
        }

        int sum = 0;
        for (String word : words) {
            int result = 0;
            for (char c: word.toCharArray()) {
                result = result * 10 + alphaNum.get(c);
            }
            sum += result;
        }

        System.out.println(sum);
    }

}