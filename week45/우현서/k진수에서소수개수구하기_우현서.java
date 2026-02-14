// 10진수 -> k진수
// Integer.toString(n, k);

class Solution {
    public int solution(int n, int k) {
        String changed = Integer.toString(n, k);
        String[] splited = changed.split("0");

        int count = 0;

        for (String s: splited) {
            if(s.equals("")) continue;

            long num = Long.valueOf(s);
            if (isPrime(num)) count++;
        }

        return count;
    }

    public boolean isPrime(long n) {
        if (n < 2) return false;

        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}