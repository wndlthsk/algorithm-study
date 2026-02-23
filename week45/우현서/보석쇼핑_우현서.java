// 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간 찾기
// [시작 진열대 번호, 끝 진열대 번호] 리턴
// 여러개면 시작 진열 번호가 작은 구간 리턴

// 개수 세놓고 투포인터 -> l=0, r=n-1로 투포인터 돌면 중간에서 최소 구간을 인지 못함
// -> 슬라이딩 윈도우로 해야함


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};

        Set<String> types = new HashSet<>();
        for (String g: gems) {
            types.add(g);
        }
        int typeCnt = types.size();
        // System.out.println(typeCnt);

        int l = 0;
        int r = 0;
        int n = gems.length;

        int count = 0;
        Map<String, Integer> countMap = new HashMap<>();
        int bestL = 0;
        int bestR = 0;
        int minLen = Integer.MAX_VALUE;

        while (l <= r && r<n) {
            if (count < typeCnt) {
                String gemR = gems[r];
                int cntR = countMap.getOrDefault(gemR, 0);
                if (cntR == 0) count++;
                countMap.put(gemR, cntR+1);
                r++;
            }

            while (count == typeCnt) {
                int len = r - l; // 위에서 r++하기 때문
                if (len < minLen) {
                    bestL = l;
                    bestR = r-1;
                    minLen = len;
                }

                String gemL = gems[l];
                int cntL = countMap.get(gemL);

                if (cntL == 1) {
                    countMap.remove(gemL);
                    count--;
                    l++;
                    break;
                }

                countMap.put(gemL, cntL-1);
                l++;
            }
            // System.out.println("r: " + r + " l: " + l);
        }

        return new int[]{bestL + 1, bestR + 1};
    }
}