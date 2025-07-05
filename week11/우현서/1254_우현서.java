// 팰린드롬 문자열(앞에서부터 or 뒤에서부터 같게 읽히는 문자열)
// 문자열 s에 0개이상 추가해 팰린드롬 만드는데 가장 짧은 문자열의 길이
// i(0~n-1)을 제외한 substring을 팰린드롬인지 검사, 맞다면 앞의 i개를 뒤에 추가하면됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = input.length();
        for (int i=0; i<n; i++) {
            if (isPalindrome(input.substring(i, n))) {
//                System.out.println(input.substring(i, n));
                System.out.println(n + i);
                return;
            }
        }

    }
}