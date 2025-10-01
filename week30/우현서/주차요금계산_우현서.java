// 입차, 출차 기록
// 차량별 주차 요금 계산
// 출차 내역 없으면 23:59에 출차로 간주
// 요금은 일괄로 정산
// 누적 주차 시간 <= 기본 시간 : 기본 요금 청구
// 누적 주차 시간 > 기본 시간 : 기본 요금 + 초과 시간에 대해 단위 시간마다 단위 요금 청구
// 초과시간 / 단위시간 올림으로 처리
// fees: 주차 요금 정수배열
// records: 자동차 입/출차 내역 문자열 배열
// 차번호가 작은 차부터 청구 요금을 차례대로 정수배열로 리턴

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

class Parking {
    LocalTime inTime;
    LocalTime outTime;
    Long totalTime;

    public Parking(LocalTime inTime, LocalTime outTime) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.totalTime = 0L;
    }

    public void setInTime(LocalTime time) {
        this.inTime = time;
    }

    public void setOutTime(LocalTime time) {
        this.outTime = time;
    }

    public void out() {
        this.totalTime += Duration.between(this.inTime, this.outTime).toMinutes();
        this.inTime = null;
        this.outTime = null;
    }

    @Override
    public String toString() {
        return "inTime: " + inTime + " outTime: " + outTime + " totalTime: " + totalTime;
    }
}


class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Parking> infos = new TreeMap<>(); // treemap하면 자동 키 오름차순

        for (String re: records) {
            String[] splited = re.split(" ");
            LocalTime time = LocalTime.parse(splited[0]);
            int carNo = Integer.valueOf(splited[1]);
            String word = splited[2];

            infos.putIfAbsent(carNo, new Parking(time, null));
            Parking p = infos.get(carNo);

            if (word.equals("IN")) {
                p.setInTime(time);
            } else {
                p.setOutTime(time);
                p.out();
            }
        }
        // System.out.println(infos);

        int[] answer = new int[infos.size()];
        int idx = 0;
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for (Parking p : infos.values()) {
            // 출차 시간 없는 거 처리
            if (p.inTime != null && p.outTime == null) {
                p.setOutTime(LocalTime.of(23, 59));
                p.out();
            }

            long totalTime = p.totalTime;
            int totalFee = baseFee;
            if (totalTime > baseTime) {
                long extraTime = totalTime - baseTime;
                totalFee += Math.ceil((double) extraTime / unitTime) * unitFee;
            }
            answer[idx++] = totalFee;
        }

        return answer;
    }
}