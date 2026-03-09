class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int pos = (num - 1) % w;

        int col;
        if (row % 2 == 0) col = pos;
        else col = w - 1 - pos;

        int height = (n + w - 1) / w;
        int last = n % w;

        int stackHeight = height;

        if (last != 0) {
            int topRow = height - 1;
            boolean exists;

            if (topRow % 2 == 0) {
                exists = (col < last);
            } else {
                exists = (col >= w - last);
            }

            if (!exists) {
                stackHeight = height - 1;
            }
        }

        return stackHeight - row;
    }
}