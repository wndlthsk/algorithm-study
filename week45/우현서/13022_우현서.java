import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// n번씩 나오면 올바른 단어, 올바를 단어 2ㅐㄱ를 이은 단어도 올바른 단어
// 올바른 단어면 1, 아니면 0 출력

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();
        char[] chars = s.toCharArray();

        int i = 0;
        while (i <  n) {
            if (chars[i] != 'w') {
                System.out.println("0");
                return;
            }

            int count = 0;
            while (i<n && chars[i] == 'w') {
                count++;
                i++;
            }

            int temp = 0;
            while (i<n && chars[i] == 'o') {
                temp++;
                i++;
                if (temp > count) break;
            }
            if (temp != count) {
                System.out.println("0");
                return;
            }

            temp = 0;
            while (i<n && chars[i] == 'l') {
                temp++;
                i++;
                if (temp > count) break;
            }
            if (temp != count) {
                System.out.println("0");
                return;
            }

            temp = 0;
            while (i<n && chars[i] == 'f') {
                temp++;
                i++;
                if (temp > count) break;
            }
            if (temp != count) {
                System.out.println("0");
                return;
            }
        }

        System.out.println("1");

    }
}