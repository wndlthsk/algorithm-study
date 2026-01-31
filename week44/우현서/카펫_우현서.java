package week44.우현서;// 카펫의 가로 세로 크기 구해
// 2x + 2y - 4 = brown,
// (x-2) * (y-2) = yellow
// x >= y
// x+y = brown/2 +2

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int sum = brown / 2 + 2;
        int y = 3;

        while (true) {
            int x = sum - y;

            if ((x - 2) * (y - 2) == yellow) {
                return new int[]{x, y};
            }

            y++;
        }
    }
}