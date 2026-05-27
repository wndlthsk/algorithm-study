// 숫자 -> 2진수 : Integer.toBinaryString(num);


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        StringBuilder sb;
        for (int i=0; i<n; i++) {
            sb = new StringBuilder();

            int temp = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(temp);

            while (binary.length() < n) { // 앞에 0 추가
                binary = "0" + binary;
            }

            for (char c: binary.toCharArray()) {
                if (c == '0') sb.append(" ");
                else sb.append("#");
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}