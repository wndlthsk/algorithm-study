N = int(input())
arr = [int(input()) for _ in range(N)]

pos = []     # 양수(>1)
neg = []     # 음수
ones = 0     # 1의 개수
zero = 0     # 0의 개수

for x in arr:
  if x > 1:
    pos.append(x)
  elif x == 1:
    ones += 1
  elif x == 0:
    zero += 1
  else:
    neg.append(x)

pos.sort(reverse=True)
neg.sort()

result = 0

# 양수 묶기
for i in range(0, len(pos), 2):
  if i + 1 < len(pos):
    result += pos[i] * pos[i+1]
  else:
    result += pos[i]

# 음수 묶기
for i in range(0, len(neg), 2):
  if i + 1 < len(neg):
    result += neg[i] * neg[i+1]
  else:
    # 음수 하나 남았을 때
    if zero:
      # 0과 곱해 상쇄
      pass
    else:
      result += neg[i]

# 1은 전부 더하기
result += ones

print(result)