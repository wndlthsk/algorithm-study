// 양의 정수 n, 이를 k진수로 바꿨을때 변환된 수 안에 소수가 몇개인지
// 소수 양쪽에 0있는 경우
// 소수 오른쪽에만 0, 왼쪽엔 암것도 없음
// 소수 왼쪽에만 0, 오른쪽엔 암것도 없음
// 소수 양쪽에 암것도 없음
// 소수는 각 자릿수에 0을 포함하지 않는 소수임

// k진수로 변환
// 소수 판별
// Integer.toString(int i, int r): i를 r진수로 변환
// Long.parseLong(String s) : s를 long으로 변환

class Solution {
    public int solution(int n, int k) {
        String changed = Integer.toString(n, k);
        // System.out.println(changed);

        String[] splited = changed.split("0");
        // System.out.println(Arrays.toString(splited));

        int answer = 0;

        for(String s: splited) {
            if (s.equals("") || s.equals("1")) continue;
            // System.out.println(Integer.parseInt(s));
            // System.out.println(isPrime(Integer.parseInt(s)));

            if (isPrime(Long.parseLong(s))) answer++;
        }

        return answer;
    }

    public boolean isPrime(long n) {
        for(int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}