// n명 참가, 토너먼트
// 1~n번, n-1번 & n번 참가자 게임 진행
// 다음 라운드 진출하면 1~n/2번 배정
// 최종 한명 남을 때까지 게임 진행
// 첫 라운드 a번, b번인 참가자가 몇번째 라운드에서 만나는지 구하기

// 공통 부모가 아래부터 몇번째인지
// 번호 x의 부모 번호는 ceil(x/2)이다

class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 0;

        double A = (double) a;
        double B = (double) b;
        while (A != B) {
            A = Math.ceil(A / 2);
            B = Math.ceil(B / 2);

            count++;
        }

        return count;
    }
}