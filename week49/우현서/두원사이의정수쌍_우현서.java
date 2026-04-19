// 두 원 사이 공간에서 x, y가 모두 정수인 좌표 개수 리턴
// 4부분 차이 구하기

// 각 x에서, 두 원 사이에 있는 y좌표를 세는 것
// y ≤ √(r2² - x²)
// y ≥ √(r1² - x²)

class Solution {
    public long solution(int r1, int r2) {

        long answer = (long) (r2 - r1 + 1) * 4;

        for (int x = 1; x < r2; x++) {
            int smallY = (int)Math.sqrt((long)r1*r1 - (long)x*x);
            int bigY = (int)Math.sqrt((long)r2*r2 - (long)x*x);
            answer += (long)(bigY - smallY) * 4;

            // 작은 원 경계 위 정수 점을 다시 더하기
            if(x<r1 && Math.sqrt((long)r1*r1 - (long)x*x)%1 ==0) answer+=4;

        }


        return answer;
    }
}