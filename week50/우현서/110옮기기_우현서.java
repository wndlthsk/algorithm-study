// 110 찾아서 마지막 0 뒤에

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i=0; i<s.length; i++) {
            String str = s[i];
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int count = 0;


            for (int j=0; j<chars.length; j++) {
                sb.append(chars[j]);
                int l = sb.length();


                if (l >= 3 && sb.charAt(l-3) == '1' && sb.charAt(l-2) == '1' && sb.charAt(l-1) == '0') {
                    sb.delete(l-3, l);
                    count++;
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