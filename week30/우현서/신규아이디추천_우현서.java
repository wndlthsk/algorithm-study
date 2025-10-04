// 규칙을 거친 아이디 리턴

class Solution {
    public String solution(String new_id) {
        // 1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        // System.out.println(new_id);

        // 2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        StringBuilder step2 = new StringBuilder();
        for(int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }
        new_id = step2.toString();
        // System.out.println(new_id);

        // 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        StringBuilder step3 = new StringBuilder();
        char before = '0';
        for(int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (c == '.') {
                if (before != '.') step3.append(c); // 처음 등장하는 .만 추가
            } else { // . 외의 문자는 추가
                step3.append(c);
            }
            before = c;
        }
        new_id = step3.toString();
        // System.out.println(new_id);

        // 4. 마침표(.)가 처음이나 끝에 위치한다면 제거
        if(new_id.length() > 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0, new_id.length()-1);
        }
        // System.out.println(new_id);

        // 5. 빈 문자열이라면, new_id에 "a"를 대입
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        if(new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0, new_id.length()-1);
        }
        // System.out.println(new_id);

        // 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
        if (new_id.length() <= 2) {
            StringBuilder step7 = new StringBuilder(new_id);
            char last = new_id.charAt(new_id.length()-1);
            while (step7.length() < 3) {
                step7.append(last);
            }
            new_id = step7.toString();
        }

        return new_id;
    }
}