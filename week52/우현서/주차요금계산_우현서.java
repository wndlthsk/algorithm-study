import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Info {
    int number;
    int totalSec = 0;
    int lastInSec = -1;

    public Info(int number, int inSec) {
        this.number = number;
        this.lastInSec = inSec;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int stdSec = fees[0] * 60;
        int stdMoney = fees[1];
        int unitSec = fees[2] * 60;
        int unitMoney = fees[3];

        Map<Integer, Info> carMap = new HashMap<>();

        for (String r : records) {
            String[] splited = r.split(" ");
            String[] time = splited[0].split(":");

            int second = Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60;
            int number = Integer.parseInt(splited[1]);

            if (splited[2].equals("IN")) {
                if (!carMap.containsKey(number)) {
                    carMap.put(number, new Info(number, second));
                } else {
                    carMap.get(number).lastInSec = second;
                }
            } else {
                Info info = carMap.get(number);
                info.totalSec += (second - info.lastInSec);
                info.lastInSec = -1; // 출차 처리 표시
            }
        }

        List<int[]> result = new ArrayList<>();

        for (Info info : carMap.values()) {
            if (info.lastInSec != -1) {
                int lastSec = 23 * 3600 + 59 * 60;
                info.totalSec += (lastSec - info.lastInSec);
            }

            // 요금 계산
            if (info.totalSec <= stdSec) {
                result.add(new int[]{info.number, stdMoney});
            } else {
                int extraTime = info.totalSec - stdSec;
                int totalMoney = stdMoney + (int) Math.ceil((double) extraTime / unitSec) * unitMoney;
                result.add(new int[]{info.number, totalMoney});
            }
        }

        // 차 번호 기준 오름차순 정렬
        result.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i)[1];
        }

        return answer;
    }
}