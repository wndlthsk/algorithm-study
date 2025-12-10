from collections import deque

N = int(input())
nums = list(map(int, input().split()))

# (풍선 번호, 이동값) 형태로 저장
q = deque((i + 1, n) for i, n in enumerate(nums))

res = []
while q:
  idx, move = q.popleft()
  res.append(idx)
  
  if not q:
    break
  
  if move > 0:
    q.rotate(-(move - 1))
  else:
    q.rotate(-move)
print(*res)