import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] words = new String[N];
        Map<Character, Integer> weightMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                char ch = words[i].charAt(j);
                int power = (int) Math.pow(10, len - j - 1);
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + power);
            }
        }

        List<Integer> weights = new ArrayList<>(weightMap.values());
        weights.sort(Collections.reverseOrder());

        int num = 9;
        int sum = 0;
        for (int w : weights) {
            sum += w * num--;
        }

        System.out.println(sum);
    }
}
