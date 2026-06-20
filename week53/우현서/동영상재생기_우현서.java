// prev 10초 전 이동, 10미만이면 0으로 이동
// next 10초 후 이동, 남은 시간이 10미만이면 마지막으로
// 현재 위치가 오프닝 구간이면 오프닝 끝나는 위치로 이동

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoEnd = toSecond(video_len);
        int now = toSecond(pos);
        int openingStart = toSecond(op_start);
        int openingEnd = toSecond(op_end);


        if (now >= openingStart && now <= openingEnd) {
            now = openingEnd;
        }

        for (String c: commands) {
            if (c.equals("prev")) {
                if (now <= 10) now = 0;
                else now -= 10;
            } else if (c.equals("next")) {
                if (videoEnd - now <= 10) now = videoEnd;
                else now += 10;
            }

            if (now >= openingStart && now <= openingEnd) {
                now = openingEnd;
            }
        }

        int h = now / 60;
        int m = now % 60;


        return String.format("%02d:%02d", h, m);
    }

    private int toSecond(String time) {
        String[] splited = time.split(":");
        return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
    }
}