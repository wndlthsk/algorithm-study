// prev: 10초전 이동, 현재가 10초 미만이면 처음으로
// next: 10초후 이동, 남은게 10초 미만이면 마지막으로
// 현재 위치가 오프닝 구간이면 자동으로 오프닝 건너뛰기
// 입력 후 마지막 동영상 위치

// 전부 초로 바꿔서 계산

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int now = toSecond(pos);
        int end = toSecond(video_len);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);

        if (now >= opStart && now < opEnd) {
            now = opEnd;
        }

        for (String command: commands) {
            if (command.equals("prev")) {
                now = Math.max(0, now-10);
            } else {
                now = Math.min(end, now+10);
            }

            if (now >= opStart && now < opEnd) {
                now = opEnd;
            }
        }

        int m = now / 60;
        int s = now % 60;
        return String.format("%02d:%02d", m, s);
    }

    public int toSecond(String time) {
        String[] splited = time.split(":");
        return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
    }

}