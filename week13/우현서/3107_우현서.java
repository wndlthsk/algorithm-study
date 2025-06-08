import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] shorten = br.readLine().split(":", -1);
//        System.out.println(Arrays.toString(shorten));

        int count = 0;
        for (String s : shorten) {
            if(!s.isEmpty()) count++;
        }
        int missing = 8-count; // 0000으로 채워야할 개수
//        System.out.println("missing: " + missing);

        boolean zero = false;
        List<String> result = new ArrayList<>();
        for (String s : shorten) {
            if (s.length() == 4) {
                result.add(s);
            } else if (s.length() < 4 && !s.isEmpty()) {
                result.add("0".repeat(4 - s.length()) + s);
            } else if (s.isEmpty() && !zero) {
                for (int j = 0; j < missing; j++) {
                    result.add("0000");
                }
                zero = true;
            }
        }
//        System.out.println(result);
        System.out.println(String.join(":", result));
    }
}