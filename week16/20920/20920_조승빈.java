import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         Map<String, Integer> vis = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                vis.put(word, vis.getOrDefault(word, 0) + 1);
            }
        }

        List<String> wordList = new ArrayList<>(vis.keySet());

        Collections.sort(wordList, (a, b) -> {
            int A = vis.get(a);
            int B = vis.get(b);
            if (A != B) {
                return B - A;
            } else if (a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
}
