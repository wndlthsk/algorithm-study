import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Set<Integer> broken = new HashSet<>();
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken.add(Integer.parseInt(st.nextToken()));
            }
        }
//        System.out.println(broken);

        int minimum = Math.abs(n-100);
        for (int i = 0; i <= 999999; i++) { // 6자리 채널의 최대값
            String channel = String.valueOf(i);
            boolean check = false;
            for (int j=0; j<channel.length(); j++) {
                if (broken.contains(channel.charAt(j)-'0')) {
                    check = true;
                    break;
                }
            }
            if (!check) { // 버튼 고장 아닌 경우에만 최솟값 갱신
                minimum = Math.min(minimum, channel.length() + Math.abs(n-i));
            }
        }

        System.out.println(minimum);
    }
}