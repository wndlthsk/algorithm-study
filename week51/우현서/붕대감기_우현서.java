class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int n = attacks.length;
        int h = health;

        int attack = 0;
        int success = 0;

        for (int t=1; t<=attacks[n-1][0]; t++) {
            if (attacks[attack][0] == t) {
                h -= attacks[attack][1];
                if (h <= 0) return -1;

                success = 0;
                attack++;
            } else {
                h = Math.min(health, h+bandage[1]);
                success++;

                if (success == bandage[0]) {
                    h = Math.min(health, h+bandage[2]);
                    success = 0;
                }
            }
        }


        return h;
    }
}