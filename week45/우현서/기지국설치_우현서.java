// 5g 기지국을 최소로 설치하면서 모든 아파트에 전파 전달하게
// 증설해야할 기지국 개수의 최솟값 리턴
// 1-based

class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int pointer = 1;
        int sIdx = 0;


        while (pointer <= n) {
            // 기존 기지국 남은 경우
            if (sIdx < stations.length){
                int start = stations[sIdx] - w;
                int end = stations[sIdx] + w;

                // 현재 위치가 커버되면 포인터, sidx 갱신
                if (pointer >= start && pointer <= end) {
                    pointer = end + 1;
                    sIdx++;
                    continue;
                }
            }

            // 기존 기지국 없거나 현재 위치 커버 안될때 새로운 기지국 카운트, 포인터 갱신
            count++;
            pointer += w + w + 1;
        }


        return count;
    }
}