// 카펫 중앙 노란색, 테두리 1줄은 갈색
// 노란색, 갈색 개수를 알때 전체 카펫의 가로, 세로 크기 구하기


class Solution {
    public int[] solution(int brown, int yellow) {

//         2x + 2y - 4 = brown;
//         x*y - brown = yellow;
//         x*y = brown + yellow;
//         x + y = brown/2 + 2;
//         y = (brown/2 + 2) - x;
//         x*((brown/2 + 2) - x) = brown + yellow;

//         8 <= b <= 5000
//         1 <= yell <= 2000000
//         x >= y;
//         brown/2 + 2 - y >= y;
//         2y <= brown/2 + 2;
//         y <= brown/4 + 1;

//         6 <= x+y <= 2502

        // 노란색 영역이 있으려면 3*3이 최소다.
        for (int y = 3; y <= brown/4 + 1; y++) {
            int x = (brown + 4) / 2 - y;
            if (x * y == brown + yellow && x >= y) {
                return new int[]{x, y};
            }
        }
        return new int[]{};
    }
}