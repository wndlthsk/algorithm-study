import sys
input = sys.stdin.readline

N = int(input())
std_num = list(map(int, input().split()))

stk = []
target = 1
idx = 0

while idx < N:
  if std_num[idx] == target:
    target += 1
    idx += 1
  else:
    stk.append(std_num[idx])
    idx += 1

  while stk and stk[-1] == target:
    stk.pop()
    target += 1
print("Nice" if target == N + 1 else "Sad")