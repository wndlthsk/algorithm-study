// 보트에 한번에 최대 2명, 무게 제한
// 보트 최대한 적게 사용해서 모든 사람 구출
// 보트 최소 개수 리턴

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;

        while(left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}