import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
a = deque(list(map(int, sys.stdin.readline().split())))
# print(a)

belt = deque([0] * n)
# print(belt)

count = 0
while True:
    count += 1
    # 1. 벨트와 로봇 한칸 회전
    a.rotate(1)# 벨트와 로봇이 한칸 회전
    belt.rotate(1)

    belt[n-1] = 0 # 내리는 위치의 로봇은 즉시 내림

    # 2. 끝쪽부터 이동가능하면 이동
    for i in range(n-2, -1, -1):
        if belt[i] == 1 and belt[i+1] == 0 and a[i+1] >= 1:
            belt[i+1] = 1
            belt[i] = 0
            a[i+1] -= 1

    belt[n-1] = 0 # 즉시 내리기

    # 3. 올리는 위치 가능하면 올리기
    if a[0] != 0:
        belt[0] = 1
        a[0] -= 1

    # 4. 내구도 0인 개수 >= k면 종료
    if a.count(0) >= k:
        break

print(count)