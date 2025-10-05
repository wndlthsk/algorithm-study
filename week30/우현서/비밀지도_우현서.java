// 한변 길이 n인 정사각형 지도, 공백/벽(#)
// 전체지도는 1,2를 겹처서 얻음, 둘중 하나라도 벽이면 전체지도에서도 벽, 둘다 공백이면 공백
// 1: 벽/ 0: 공백 으로 이진수로 입력됨
// 지도를 해독해서 #, 문자열 배열로 출력


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map = new int [n][n];
        for (int i=0; i<n; i++) {
            String binary = Integer.toBinaryString(arr1[i]);
            if (binary.length() < n) {
                binary = "0".repeat(n - binary.length()) + binary;
            }
            for (int j=0; j<n; j++) {
                map[i][j] = binary.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            String binary = Integer.toBinaryString(arr2[i]);
            if (binary.length() < n) {
                binary = "0".repeat(n - binary.length()) + binary;
            }
            for (int j=0; j<n; j++) {
                int temp = binary.charAt(j) - '0';
                if (map[i][j] == 0 && temp == 0) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));

        String[] answer = new String[n];

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int num : map[i]) {
                if (num == 0) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        // System.out.println(Arrays.toString(answer));

        return answer;
    }
}