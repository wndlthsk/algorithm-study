// 모든 달 28일,
// 21.1.5 -> 22.1.4까지 가능
// 오늘 날짜 기준 파기해야할 개인정보 번호 리턴
// today: 오늘날짜 "YYYY.MM.DD"
// terms: 유효기간 "약관 종류 유효기간"
// privacies: 개인정보 "날짜 약관 종류"

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate now = LocalDate.parse(today, fmt);
        // System.out.println(now);

        Map<String, Integer> termsMap = new HashMap<>();
        for (String t: terms) {
            String[] splited = t.split(" ");
            termsMap.put(splited[0], Integer.valueOf(splited[1]));
        }
        // System.out.println(termsMap);

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<privacies.length; i++) {
            String p = privacies[i];
            String[] splited = p.split(" ");
            LocalDate date = LocalDate.parse(splited[0], fmt);
            String type = splited[1];
            int addMonths = termsMap.get(type);
            int addDays = addMonths * 28;

            int day = date.getDayOfMonth() - 1;
            int month = date.getMonthValue();
            int year = date.getYear();
            // System.out.println(day + " " + month + " " + year);

            day += addDays;

            month += day / 28;
            day = day % 28;
            if (day == 0) {
                day = 28;
                month -= 1;
            }

            year += month / 12;
            month = month % 12;
            if (month == 0) {
                month = 12;
                year -= 1;
            }

            // System.out.println("after: " + day + " " + month + " " + year);

            LocalDate untilDate = LocalDate.of(year, month, day);
            if (untilDate.isBefore(now)) {
                result.add(i+1);
            }
        }

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}