// 정수를 이어 붙여 가장 큰 수 만들기

// 문자열 비교
// a.compareTo(b)

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        // System.out.println(Arrays.toString(arr));

        // 0만 있는 경우
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String a: arr) {
            sb.append(a);
        }

        return sb.toString();
    }
}