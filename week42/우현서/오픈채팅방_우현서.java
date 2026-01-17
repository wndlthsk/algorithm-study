// 모든 기록 처리된 후 최종 매시지 리턴
// record: 채팅방 입장/퇴장/변경 기록
// Enter [유저 아이디] [닉네임] / Leave [유저 아이디] / Change [유저 아이디] [닉네임]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> nickname = new HashMap<>();
        List<String[]> state = new ArrayList<>();

        int countChange = 0;
        for (String r: record) {
            String[] splited = r.split(" ");
            String[] toAdd = new String[2];

            if (splited[0].equals("Enter")) {
                toAdd[0] = "E";
                nickname.put(splited[1], splited[2]);
            }
            else if (splited[0].equals("Leave")) {
                toAdd[0] = "L";
            }
            else {
                toAdd[0] = "C";
                countChange++;
                nickname.put(splited[1], splited[2]);
            }

            toAdd[1] = splited[1];

            state.add(toAdd);
        }

        String[] result = new String[state.size()-countChange];

        int i = 0;
        for (String[] s : state) {
            if (s[0].equals("C")) continue;

            String id = s[1];

            if (s[0].equals("E")) {
                result[i] = nickname.get(id) + "님이 들어왔습니다.";
            }
            else if (s[0].equals("L")) {
                result[i] = nickname.get(id) + "님이 나갔습니다.";
            }

            i++;
        }

        return result;
    }
}