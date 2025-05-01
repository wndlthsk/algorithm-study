import sys
from collections import deque

n, w, l = map(int, sys.stdin.readline().split())
weights = list(map(int, sys.stdin.readline().split()))
# print(weights)

bridge = deque([0] * w) # 다리 길이만큼 deque, 움직일 때 popleft, 진입 가능하면 트럭 무게 삽입, 아니면 0 삽입
total_weight = 0
time = 0

for i in weights: # 트럭이 다리에 진입하는 시점 구함
    # print(i)
    while True:
        time += 1
        total_weight -= bridge.popleft()
        if total_weight + i <= l:
            bridge.append(i)
            total_weight += i
            # print(i, bridge)
            # print(time)
            break
        else:
            bridge.append(0)

print(time+w)