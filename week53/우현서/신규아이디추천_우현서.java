// 대문자 판별 : Character.isUpperCase(c)
// 소문자 변환 : Character.toLowerCase(c)
// sb 반복문 접근 : sb.charAt(i)
// sb 특정 위치 삭제 : sb2.deleteCharAt(i)
// sb 범위 삭제 : sb2.delete(s, e); // s포함, e미포함

class Solution {
    public String solution(String new_id) {

        new_id = new_id.toLowerCase();


        StringBuilder sb = new StringBuilder();

        for (int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);

            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }


        StringBuilder sb2 = new StringBuilder();
        boolean beforeIsDot = false;

        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                if (beforeIsDot) continue;
                beforeIsDot = true;
            } else {
                beforeIsDot = false;
            }

            sb2.append(sb.charAt(i));
        }


        if (sb2.length() > 0 && sb2.charAt(0) == '.') {
            sb2.deleteCharAt(0);
        }

        if (sb2.length() > 0 && sb2.charAt(sb2.length()-1) == '.') {
            sb2.deleteCharAt(sb2.length()-1);
        }

        if (sb2.length() == 0) {
            sb2.append("a");
        }

        if (sb2.length() >= 16) {
            sb2.delete(15, sb2.length()); // s포함, e미포함

            if (sb2.charAt(sb2.length()-1) == '.') {
                sb2.deleteCharAt(sb2.length()-1);
            }
        }

        char last = sb2.charAt(sb2.length()-1);
        while (sb2.length() < 3) {
            sb2.append(last);
        }



        return sb2.toString();
    }
}