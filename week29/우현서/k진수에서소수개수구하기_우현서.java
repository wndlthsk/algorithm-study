// 양의 정수 n, 이 수를 k진수로 바꿀때
// 소수 양쪽에 0
// 소수 오른쪽에 0, 왼쪽에 없음
// 소수 왼쪽 0, 오른쪽에 없음
// 소수 양쪽에 없음
// 각 자릿수에 0을 포함하지 않는 소수

class Solution {
    public int solution(int n, int k) {
        // int answer = -1;
        String changed = Integer.toString(n, k);
        // System.out.println(changed);
        String[] splited = changed.split("0");
        // System.out.println(Arrays.toString(splited));

        int count = 0;
        for (String s: splited) {
            if (s.isEmpty()) continue;
            long num = Long.parseLong(s);
            if (num > 1 && isPrime(num)) {
                count++;
            }
        }
        // System.out.println(count);
        return count;
    }

    public boolean isPrime(long n) {
        for (int i = 2; i<=(long)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}