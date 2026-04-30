// n번째 주문
// 각 알파벳마다 몇개씩 있는지

// 한글자 -> 26 / 두글자 -> 26^2 = 676 / 세글자 -> 26^26 /...


import java.util.Arrays;

class Solution {
    public String solution(long n, String[] bans) {
        long[] idxs = new long[bans.length];
        for (int i=0; i<bans.length; i++) {
            idxs[i] = getIndex(bans[i]);
        }
        // System.out.println(Arrays.toString(idxs));

        Arrays.sort(idxs);

        for (long idx: idxs) {
            if (idx <= n) n++;
            else break;
        }
        // System.out.println(n);


        return getString(n);
    }

    public long getIndex(String s) {
        long idx = 0;

        // 짧은 길이 누적
        for (int len = 1; len < s.length(); len++) {
            idx += Math.pow(26, len);
        }

        // 같은 길이에서 위치
        long cur = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = cur * 26 + (s.charAt(i) - 'a');
        }

        return idx + cur + 1;
    }


    public String getString(long n) {
        int len = 1;
        long count = 26; // 26

        // 길이 찾기
        while (n > count) {
            n -= count;
            len++;
            count = (long) Math.pow(26, len);
        }

        StringBuilder sb = new StringBuilder();
        n--;

        for (int i = 0; i < len; i++) {
            sb.append((char) ('a' + (n % 26)));
            n /= 26;
        }

        return sb.reverse().toString();
    }
}