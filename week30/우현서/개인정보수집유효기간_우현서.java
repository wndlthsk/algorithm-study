// 개인정보 1~n개
// 각 약관마다 개인정보 유효기간
// 오늘 날짜로 파기해야할 개인정보 번호 오름차순 구하기
// 모든 달 28

// today: 오늘 날짜 스트링/ terms: 유효기간 문자열 배열/ privacies: 개인정보 정보 문자열 배열

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        Map<String, Long> termMap = new HashMap<>();
        for (String t: terms) {
            String[] splited = t.split(" ");
            termMap.put(splited[0], Long.valueOf(splited[1]));
        }
        // System.out.println(todayDate);
        // System.out.println(termMap);

        long todayDays = changeToDays(todayDate);

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String p = privacies[i];
            String[] splited = p.split(" ");
            LocalDate addDate = LocalDate.parse(splited[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            String term = splited[1];

            long possibleDays = changeToDays(addDate) + termMap.get(term) * 28;
            if (todayDays >= possibleDays) {
                result.add(i+1);
            }
        }
        // System.out.println(result);

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public long changeToDays(LocalDate date) {
        return date.getYear() * 12 * 28 + (date.getMonthValue()-1) * 28 + date.getDayOfMonth();
    }
}