// <, >가 k개 나열된 순서열 A
// 부등호 앞 뒤에 서로 다른 한 자릿수 숫자를 넣어 모든 부등호 관계를 만족시켜야한다.
// 주어진 부등호 관계를 만족하는 정수의 최댓값, 최솟값
// 0~9 중에 선택해야하며, 선택된 숫자는 모두 달라야한다.
// k: 부등호 문자의 개수

// 완전 탐색
// 숫자 하나씩 넣어본다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static Character[] chars;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        chars = new Character[k];
        for (int i = 0; i < k; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
//        System.out.println(Arrays.toString(chars));

        visited = new boolean[10];
        backtrack(0, "");
        System.out.println(maxString);
        System.out.println(minString);
    }

    static String maxString = null;
    static String minString = null;

    static public void backtrack(int count, String nowNum) { // 숫자 완성 개수, 현재까지 숫자 문자열
        if (count == k+1) {
            if (maxString == null || nowNum.compareTo(maxString) > 0) maxString = nowNum;
            if (minString == null || nowNum.compareTo(minString) < 0) minString = nowNum;
            return;
        }

        for (int i=0; i<=9; i++) {
            if (!visited[i]) {
                if (count == 0 || isValid(nowNum.charAt(count-1)-'0', i, chars[count-1])) {
                    visited[i] = true;
                    backtrack(count+1, nowNum + i);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean isValid (int before, int now, char c) {
        if (c == '<') {
            return before < now;
        } else if (c == '>') {
            return before > now;
        }
        return false;
    }
}