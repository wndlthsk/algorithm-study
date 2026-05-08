// 차량별 주차 요금 계산
// 출차 내역 없으면 23:59에 출차된 것
// 기본 시간 이하면 기본 요금 청구
// 초과 시간에 단위시간마다 단위 요금 청구, 초과 시간은 올림
// 차 번호 오름차순
// records : "시각 차량번호 내역"

// 시간을 분으로 바꿔서 계산하자


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Info {
    int number;
    int totalMin;
    int inMin;

    public Info(int number, int inMin) {
        this.number = number;
        this.inMin = inMin;
    }

    @Override
    public String toString() {
        return "num: " + number + " in: " + inMin + " total: " + totalMin;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {

        int stdMin = fees[0];
        int stdMoney = fees[1];
        int unitMin = fees[2];
        int unitMoney = fees[3];

        Map<Integer, Info> carMap = new HashMap<>();

        for (String r: records) {
            String[] splited = r.split(" ");
            String[] time = splited[0].split(":");

            int minute = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            int number = Integer.parseInt(splited[1]);

            if (splited[2].equals("IN")) {
                if (carMap.containsKey(number)) {
                    carMap.get(number).inMin = minute;
                } else {
                    carMap.put(number, new Info(number, minute));
                }
            } else {
                Info info = carMap.get(number);
                info.totalMin += minute - info.inMin;
                info.inMin = -1;
            }
        }

        // System.out.println(carMap);

        List<int[]> result = new ArrayList<>();

        for (Info info: carMap.values()) {
            if (info.inMin != -1) {
                info.totalMin += (23 * 60 + 59) - info.inMin;
            }

            // System.out.println(info);


            if (info.totalMin <= stdMin) { // 기본 시간보다 적으면 기본요금
                result.add(new int[]{info.number, stdMoney});
            } else {
                int extraTime = info.totalMin - stdMin;
                int totalMoney =  stdMoney + (int)(Math.ceil((double)extraTime/unitMin) * unitMoney);
                result.add(new int[]{info.number, totalMoney});
            }

        }

        result.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i)[1];
        }



        return answer;
    }
}