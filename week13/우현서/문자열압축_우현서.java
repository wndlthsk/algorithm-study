// 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 압축
// 문자열을 1개 이상의 단위로 잘라서 압축
// 문자열의 앞부터 정해진 길이만큼 잘라야함

import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;

        for (int size=1; size<= n/2; size++) {
            StringBuilder after = new StringBuilder();
            String before = s.substring(0, size);
            int count = 1;

            int i;
            for(i=size; i<n; i+=size) {
                int end = i + size;
                if (end > n) end = n;
                String now = s.substring(i, end);

                if (before.equals(now)) {
                    count++;
                } else {
                    if (count > 1) {
                        after.append(count+""+before);
                    } else {
                        after.append(before);
                    }
                    before = now;
                    count = 1;
                }
            }

            // 마지막 단위 처리
            if (count > 1) {
                after.append(count+""+before);
            } else {
                after.append(before);
            }

            answer = Math.min(answer, after.toString().length());
        }

        return answer;
    }
}