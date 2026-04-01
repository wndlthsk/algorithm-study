class Solution {
    public int solution(int[][] sizes) {

        int maxBig = 0;
        int maxSmall = 0;
        for (int[] size: sizes) {
            int big = Math.max(size[0], size[1]);
            int small = Math.min(size[0], size[1]);

            maxBig = Math.max(maxBig, big);
            maxSmall = Math.max(maxSmall, small);

        }

        return maxBig * maxSmall;
    }
}