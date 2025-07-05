import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }
        int max = Collections.max(map.values());
        String ans = "";
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                if (ans.equals("") || key.compareTo(ans) < 0) {
                    ans = key;
                }
            }
        }
        System.out.println(ans);
    }
}
