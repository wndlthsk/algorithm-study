// 문자열 x를 사전순으로 가장 앞에 오는 문자열 리턴
// 110을 뽑아서 삽입할 수 있음


class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i=0; i<s.length; i++) {
            String str = s[i];
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (char c: str.toCharArray()) {
                sb.append(c);
                int l = sb.length();

                if (l >= 3 && c == '0' && sb.charAt(l-3) == '1' && sb.charAt(l-2) == '1') {
                    count++;
                    sb.delete(l-3, l);
                }
            }

            int idx = sb.lastIndexOf("0");
            for (int c=0; c<count; c++) {
                sb.insert(idx+1, "110");
            }

            answer[i] = sb.toString();
        }


        return answer;
    }
}