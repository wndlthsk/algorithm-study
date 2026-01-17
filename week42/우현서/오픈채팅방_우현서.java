// 모든 기록 처리된 후 최종 매시지 리턴
// record: 채팅방 입장/퇴장/변경 기록
// Enter [유저 아이디] [닉네임] / Leave [유저 아이디] / Change [유저 아이디] [닉네임]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickname = new HashMap<>();
        List<String[]> state = new ArrayList<>();

        for (String r: record) {
            String[] splited = r.split(" ");
            String action = splited[0];
            String id = splited[1];

            if (action.equals("Enter")) {
                nickname.put(id, splited[2]);
                state.add(new String[]{"E", id});
            }
            else if (action.equals("Leave")) {
                state.add(new String[]{"L", id});
            }
            else {
                nickname.put(id, splited[2]);
            }
        }

        String[] result = new String[state.size()];

        for (int i=0; i<state.size(); i++) {
            String[] log = state.get(i);
            String action = log[0];
            String id = log[1];

            result[i] = nickname.get(id) + (action.equals("E") ? "님이 들어왔습니다." : "님이 나갔습니다.");
        }

        return result;
    }
}