// 트럭에 최대 cap개 실을 수 있음
// 모든 배달, 수거하고 물류창고로 돌아오는 최소 이동 거리
// 1-based

// 멀리부터 처리하기
// 갈때 배달, 올때 수거한다고 생각

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int truck = 0;
        int dPointer = n-1;
        int pPointer = n-1;
        long distance = 0;

        while (dPointer >= 0 || pPointer >= 0) {
            // 0인곳 패스
            while (dPointer >= 0 && deliveries[dPointer] == 0) dPointer--;
            while (pPointer >= 0 && pickups[pPointer] == 0) pPointer--;

            // 이동 거리 갱신
            distance += 2 * (Math.max(dPointer, pPointer) + 1);

            // 배달
            truck = 0;
            while (dPointer >= 0) {
                // i집의 택배를 모두 실을 수 없으면
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
                // i집의 빈박스를 모두 실을 수 없으면
                if (truck + pickups[pPointer] > cap) {
                    pickups[pPointer] -= cap - truck;
                    break;
                }
                truck += pickups[pPointer];
                pickups[pPointer] = 0;
                pPointer--;
            }
        }
        // System.out.println("----");
        // System.out.println(Arrays.toString(deliveries));
        // System.out.println(Arrays.toString(pickups));
        // System.out.println(distance);

        return distance;
    }
}