// 큐 두개, 큐1에서 팝, 큐2에 인서트
// 각 큐의 원소합이 같도록
// 작업의 최소 횟수
// 불가능하면 -1

// 합이 큰곳에서 꺼내기
// 투포인터도 가능, 길이 n짜리 연속 구간의 합을 target으로 맞추는 것

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 투포인터
        int n = queue1.length;

        long sum1 = 0;
        long total = 0;
        int[] arr = new int[2*n];
        for (int i=0; i<n; i++) {
            sum1 += queue1[i];
            total += queue1[i] + queue2[i];
            arr[i] = queue1[i];
            arr[i+n] = queue2[i];
        }
        if (total % 2 != 0) return -1;
        long target = total / 2;

        int l = 0;
        int r = n;
        int count = 0;
        while (count <= 4*n) {
            if (sum1 == target) return count;

            if (sum1 > target) {
                sum1 -= arr[l % (2 * n)];
                l++;
            } else {
                sum1 += arr[r % (2 * n)];
                r++;
            }
            count++;
        }

        return -1;


        // 큐 사용
//         int n = queue1.length;

//         long sum1 = 0;
//         long sum2 = 0;
//         Queue<Integer> q1 = new ArrayDeque<>();
//         Queue<Integer> q2 = new ArrayDeque<>();
//         for (int i=0; i<n; i++) {
//             q1.add(queue1[i]);
//             sum1 += queue1[i];
//             q2.add(queue2[i]);
//             sum2 += queue2[i];
//         }

//         // System.out.println(sum1 + " " + sum2);

//         int count = 0;
//         for (int i=0; i<4*n; i++) {
//             if (sum1 == sum2) break;

//             count++;
//             if (sum1 > sum2) {
//                 int x = q1.poll();
//                 q2.offer(x);
//                 sum1 -= x;
//                 sum2 += x;
//             } else {
//                 int x = q2.poll();
//                 q1.offer(x);
//                 sum1 += x;
//                 sum2 -= x;
//             }

//             // System.out.println(sum1 + " " + sum2);
//         }


//         return sum1 == sum2 ? count : -1;
    }
}