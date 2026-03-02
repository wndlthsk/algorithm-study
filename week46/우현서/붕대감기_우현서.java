// t초동안 붕대 감으면서 1초마다 x만큼의 체력 회복, t초 연속으로 감으면 y 체력 추가 회복
// 최대 체력보다 커지는건 불가능
// 감는동안 공격당하는 기술 취소됨
// 체력 0이하되면 죽음
// 모든 공격 후 남은 체력 리턴, 죽으면 -1 리턴

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int n = attacks.length;
        int limit = attacks[n-1][0];
        int nowHealth = health;

        int attackIdx = 0;
        int success = 0; // 연속 성공 횟수
        for (int i=1; i<=limit; i++) {
            if (attacks[attackIdx][0] == i) {
                nowHealth -= attacks[attackIdx][1];
                if (nowHealth <= 0) return -1;

                success = 0;
                attackIdx++;
            } else {
                nowHealth = Math.min(health, nowHealth+bandage[1]);
                success++;

                if (success == bandage[0]) {
                    nowHealth = Math.min(health, nowHealth+bandage[2]);
                    success = 0;
                }
            }
        }

        return nowHealth;
    }
}