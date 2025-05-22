// s->t 로 문자열 바꿀 수 있는지 여부
// 문자열 뒤에 A 추가, 문자열 뒤집고 뒤에 B 추가
// t 문자열을 뒤에서부터 확인하면서 s가 될 수 있는지로 풀기

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        for (int i = t.length() - 1; i >= 0; i--) {
            if (t.length() <= s.length()) break;
            char c = t.charAt(i);
            if (c == 'A') {
                t = t.substring(0, t.length() - 1);
            } else if (c == 'B') {
                t = t.substring(0, t.length() - 1);
                t = new StringBuilder(t).reverse().toString();
            }
        }
//        System.out.println(t);
//        System.out.println(s);

        System.out.println(t.equals(s) ? 1: 0);
    }
}