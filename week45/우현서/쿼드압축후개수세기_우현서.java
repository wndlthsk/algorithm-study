// 특정 영역 s 내부에 수가 같은 값이면 하나로 압축
// 아니면 4개 영역을 쪼갬
// 모든 값은 0 or 1

class Solution {
    public int[] solution(int[][] arr) {
        int n = arr.length;

        compress(0, 0, n, arr);

        return new int[]{count0, count1};
    }

    int count0 = 0;
    int count1 = 0;

    public void compress(int i, int j, int size, int[][] arr) {
        if (isPossible(i, j, size, arr)) {
            if (arr[i][j] == 0) count0++;
            else count1++;

            return;
        }

        // 아니면 다시 4분할
        int newSize = size/2;
        compress(i, j, newSize, arr);
        compress(i, j+newSize, newSize, arr);
        compress(i+newSize, j, newSize, arr);
        compress(i+newSize, j+newSize, newSize, arr);

    }

    public boolean isPossible(int i, int j, int size, int[][] arr) {
        int before = arr[i][j];

        for (int a=i; a<i+size; a++) {
            for (int b=j; b<j+size; b++) {
                if (arr[a][b] != before) return false;
            }
        }

        return true;
    }
}