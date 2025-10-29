// 일렬로 나열된 n개의 집에 택배 배달
// 배달하면서 빈 상자 수거
// i번째 집은 물류 창고에서 거리 i만큼 떨어져있음
// j번째 집과 j-i만큼 떨어져있음
// 트럭에 최대 cap개 실을 수 있음
// 모든 배달&수거 마치고 물류창고로 돌아올 수 있는 최소 이동 거리 구하기


class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int dPointer = n-1;
        int pPointer = n-1;

        // 값이 있는 가장 먼 곳에서 시작하기 위해 포인터 조절
        while (dPointer >= 0 && deliveries[dPointer] == 0) dPointer--;
        while (pPointer >= 0 && pickups[pPointer] == 0) pPointer--;

        while (dPointer >= 0 || pPointer >= 0) {
            answer += (Math.max(dPointer, pPointer) + 1) * 2;

            // 한번의 왕복으로 움직일 수 있는 곳까지 d포인터 조절
            int d = cap; // 배달할 수 있는 개수
            while (dPointer >= 0 && d > 0) {
                int deliver = Math.min(d, deliveries[dPointer]);
                deliveries[dPointer] -= deliver;
                d -= deliver;

                while (dPointer >= 0 && deliveries[dPointer] == 0) {
                    dPointer--;
                }
            }

            int p = cap; // 수거할 수 있는 개수
            while (pPointer >= 0 && p > 0) {
                int pickup = Math.min(p, pickups[pPointer]);
                pickups[pPointer] -= pickup;
                p -= pickup;

                // 더 많이 수거할 수 있으면
                while (pPointer >= 0 && pickups[pPointer] == 0) {
                    pPointer--;
                }
            }
        }

        return answer;
    }

//    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
//        long answer = 0;
//
//        // 남은 배달/수거량 누적
//        int d = 0;
//        int p = 0;
//        for (int i=n-1; i>=0; i--) {
//            d += deliveries[i]; // 이번 집 + 뒤쪽 남은 배달량 누적
//            p += pickups[i];    // 이번 집 + 뒤쪽 남은 수거량 누적
//            int count = 0;
//
//            while(d > 0 || p > 0) { // 처리해야할 배달/수거가 있으면
//                count++;
//                d -= cap;
//                p -= cap;
//            }
//
//            answer += (i+1) * 2 * count;
//        }
//
//        return answer;
//    }
}