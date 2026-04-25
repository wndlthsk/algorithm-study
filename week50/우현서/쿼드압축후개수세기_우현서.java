// 내부 숫자가 모두 같으면 하나로 압축
// 아니면 4개로 쪼개서 반복
// 남는 0,1 숫자 개수 리턴

class Solution {
    int[][] arr;

    public int[] solution(int[][] arr) {

        this.arr = arr;

        dfs(0, 0, arr.length);


        return new int[]{count0, count1};
    }

    int count0 = 0;
    int count1 = 0;


    private void dfs(int i, int j, int size) {
        if (isSame(i, j, size)) {
            int num = arr[i][j];
            if (num == 0) count0++;
            else count1++;
        } else {
            dfs(i, j, size/2);
            dfs(i+size/2, j, size/2);
            dfs(i, j+size/2, size/2);
            dfs(i+size/2, j+size/2, size/2);
        }

    }



    private boolean isSame(int i, int j, int size) {
        int num = arr[i][j];

        for (int x=i; x<i+size; x++) {
            for (int y=j; y<j+size; y++) {
                if (num != arr[x][y]) return false;
            }
        }

        return true;
    }
}