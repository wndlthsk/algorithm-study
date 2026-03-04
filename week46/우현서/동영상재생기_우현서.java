// prev: 10초전 이동, 현재가 10초 미만이면 처음으로
// next: 10초후 이동, 남은게 10초 미만이면 마지막으로
// 현재 위치가 오프닝 구간이면 자동으로 오프닝 건너뛰기
// 입력 후 마지막 동영상 위치


class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int now = toSec(pos);
        int openingStart = toSec(op_start);
        int openingEnd = toSec(op_end);
        int end = toSec(video_len);

        if (now >= openingStart && now <= openingEnd) {
            now = openingEnd;
        }

        for (String command: commands) {
            if (command.equals("prev")) {
                now = Math.max(0, now-10);
            } else {
                now = Math.min(end, now+10);
            }

            if (now >= openingStart && now <= openingEnd) {
                now = openingEnd;
            }
        }

        int m = now / 60;
        int s = now % 60;
        return String.format("%02d:%02d", m, s);
    }

    public int toSec(String str) {
        String[] splited = str.split(":");
        return Integer.valueOf(splited[0]) * 60 + Integer.valueOf(splited[1]);
    }
}