// 1~n번 개인정보 1-based
// 모든 달은 28일까지 있다고 가정
// 유효기간 지나면 파기, 같으면 안지난 거
// 오늘 날짜 기준으로 파기해야할 개인정보 번호를 오름차순 리턴

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관별 유효기간 map
        Map<String, Integer> termMap = new HashMap<>();
        for (String t: terms) {
            String[] splited = t.split(" ");
            termMap.put(splited[0], Integer.valueOf(splited[1]));
        }
        // System.out.println(termMap);

        // 오늘 날짜 int로 변경
        String[] tsplited = today.split("\\.");
        int ty = Integer.valueOf(tsplited[0]);
        int tm = Integer.valueOf(tsplited[1]);
        int td = Integer.valueOf(tsplited[2]);


        List<Integer> result = new ArrayList<>();

        for (int i=0; i<privacies.length; i++) {
            String p = privacies[i];
            String[] splited = p.split(" ");
            String[] splited2 = splited[0].split("\\.");
            int y = Integer.valueOf(splited2[0]);
            int m = Integer.valueOf(splited2[1]);
            int d = Integer.valueOf(splited2[2]);

            int days = termMap.get(splited[1]) * 28 - 1;

            d += days;
            if (d > 28) {
                // 월, 일 계산
                m += d / 28;
                d = d % 28;

                if (d == 0) {
                    d = 28;
                    m -= 1;
                }

                if (m > 12) {
                    // 연도, 월 계산
                    y += m / 12;
                    m = m % 12;

                    if (m == 0) {
                        m = 12;
                        y -= 1;
                    }
                }
            }

            // 오늘 날짜랑 유효기간 비교
            if (y < ty || (y == ty && m < tm) || (y == ty && m == tm && d < td)) {
                result.add(i+1);
            }
        }

        // System.out.println(result);
        // Collections.sort(result); // 어차피 순서대로 접근하니까 정렬 필요없음


        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}