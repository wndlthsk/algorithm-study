// 앞뒤만 빌려줄 수 있음
// 학생 최댓값 리턴

// 앞 뒷사람 확인하고 빌려줌

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int answer = n-lost.length;

        boolean[] lostStudent = new boolean[n+1];
        for (int i: lost) {
            lostStudent[i] = true;
        }

        Set<Integer> skip = new HashSet<>();
        for (int idx: reserve) {
            // 자기가 잃어버린 경우
            if (lostStudent[idx]) {
                lostStudent[idx] = false;
                answer++;
                skip.add(idx);
            }
        }

        Arrays.sort(reserve);


        for (int idx: reserve) {
            if (skip.contains(idx)) continue;

            // 앞 사람 빌려줌
            if (idx-1>=1 && lostStudent[idx-1]) {
                answer++;
                lostStudent[idx-1] = false;
                continue;
            }

            // 뒷 사람 빌려줌
            if (idx+1<=n && lostStudent[idx+1]) {
                answer++;
                lostStudent[idx+1] = false;
                continue;
            }
        }

        return answer;
    }
}