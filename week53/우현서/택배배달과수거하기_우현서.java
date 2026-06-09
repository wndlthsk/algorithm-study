// i번집은 창고에서 i만큼 떨어짐
// 최대 cap개 실을 수 있음. 배달, 수거
// 최소 이동 거리

// 갈때 배달, 올때 수거한다고 생각
// 먼곳 먼저 배달/수거 모두 처리되도록


class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dPointer = deliveries.length-1;
        int pPointer = pickups.length-1;
        int truck = 0;

        while (dPointer >= 0 || pPointer >= 0) {
            // 모두 처리한 곳 넘기기 (0 넘기기)
            while (dPointer >= 0 && deliveries[dPointer] == 0) dPointer--;
            while (pPointer >= 0 && pickups[pPointer] == 0) pPointer--;

            // 이동 거리 누적
            answer += 2 * (Math.max(dPointer, pPointer) + 1);

            // 배달
            truck = 0;
            while (dPointer >= 0) {
                if (truck + deliveries[dPointer] > cap) {
                    deliveries[dPointer] -= cap - truck;
                    break;
                }
                truck += deliveries[dPointer];
                deliveries[dPointer] = 0;
                dPointer--;
            }

            // 수거
            truck = 0;
            while (pPointer >= 0) {
                if (truck + pickups[pPointer] > cap) {
                    pickups[pPointer] -= cap - truck;
                    break;
                }
                truck += pickups[pPointer];
                pickups[pPointer] = 0;
                pPointer--;
            }
        }

        return answer;
    }
}