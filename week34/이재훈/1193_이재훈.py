X = int(input())

cross_sum = 0
line = 0

# X번째 분수가 속한 대각선 찾기
while X > cross_sum:
    line += 1
    cross_sum += line

# 해당 대각선 내에서 몇 번째인지
idx = cross_sum - X

if line % 2 == 0:  # 짝수 줄: 아래에서 위로
  num = line - idx
  den = 1 + idx
else:               # 홀수 줄: 위에서 아래로
  num = 1 + idx
  den = line - idx
print(f"{num}/{den}")