// 왼-*, 엄-# 에서 시작
// 4방향 이동, 1,4,7 -> 왼 / 3,6,9 -> 오 / 2,5,8,0 -> 더 가까운쪽, 같으면 오른손잡이/왼손잡이
// 각번호 누른 게 왼/오인지 문자열로 리턴


class Solution {
    public String solution(int[] numbers, String hand) {

        int[][] pos = {
            {3,1}, // 0
            {0,0}, // 1
            {0,1}, // 2
            {0,2}, // 3
            {1,0}, // 4
            {1,1}, // 5
            {1,2}, // 6
            {2,0}, // 7
            {2,1}, // 8
            {2,2},  // 9
            {3,0},  // *
            {3,2}  // #
        };

        int left = 10;
        int right = 11;
        StringBuilder sb = new StringBuilder();

        for (int n: numbers) {
            if (n == 1 || n == 4 || n == 7) {
                left = n;
                sb.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                right = n;
                sb.append("R");
            } else {
                int tl = Math.abs(pos[n][0] - pos[left][0]) + Math.abs(pos[n][1] - pos[left][1]);
                int tr = Math.abs(pos[n][0] - pos[right][0]) + Math.abs(pos[n][1] - pos[right][1]);

                if (tl < tr || (tl == tr && hand.equals("left"))) {
                    left = n;
                    sb.append("L");
                } else {
                    right = n;
                    sb.append("R");
                }
            }


        }

        return sb.toString();
    }
}