// 오름차순으로 정렬된 수열
// 임의의 두 인덱스의 원소와 그 사이 원소를 모두 포함하는 부분수열
// 부분수열 합은 k
// 합이 k인 부분 수열이 여러개인 경우 길이가 짧은 수열
// 길이 짧은 게 여러개면 시작 인덱스가 작은 수열을 찾는다.

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = 1000000;
        while (true) {
            // System.out.println("left: " + left + " right-1:" + (right-1) + "sum :" + sum);
            if (sum==k) {
                // System.out.println("here"+"left: " + left + " right-1:" + (right-1));
                if (right-1 - left < minLength) {
                    answer[0] = left;
                    answer[1] = right-1;
                    minLength = right-1 -left;
                }
                // 더 좁은 범위에 있는지 계속 확인
                sum -= sequence[left];
                left++;
            }
            else if (sum > k) {
                sum -= sequence[left];
                left++;
            }
            else if (sum < k) {
                if (right == sequence.length) break;
                sum += sequence[right];
                right++;
            }
        }

        return answer;
    }
}