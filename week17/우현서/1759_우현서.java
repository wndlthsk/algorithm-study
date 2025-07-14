// 암호: 서로 다른 L개의 알파벳 소문자, 최소 한개의 모음, 최소 두개의 자음
// + 사전 순 정렬
// 문자의 종류 c가지
// 3 ≤ L ≤ C ≤ 15

// 입력받은 문자를 사전순 정렬 후, 넣었다빼면서 개수가 l개가 되면 후보에 넣는다.
// -> 백트래킹 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> result;
    static int l, c;
    static String[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        chars = new String[c];
        for (int i = 0; i < c; i++) {
            chars[i] = st.nextToken();
        }
//        System.out.println(Arrays.toString(chars));
        Arrays.sort(chars);

        result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0);
//        System.out.println(result);
        for (String s: result) {
            System.out.println(s);
        }
    }

    public static void backtrack(List<String> cur, int start) {
        if (cur.size() == l) {
            // 최소 한개의 모음, 최소 두개의 자음 조건 확인
            int vCount = 0; // 모음 카운트
            int cCount = 0; // 자음 카운트

            for (String s: cur) {
                if (isVowel(s)) {
                    vCount++;
                } else {
                    cCount++;
                }
            }

            if (vCount >= 1 && cCount >= 2) {
                result.add(String.join("", cur));
            }
        }

        for (int i=start; i<c; i++) {
            cur.add(chars[i]);
            backtrack(cur, i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static boolean isVowel(String s) {
        return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
    }
}