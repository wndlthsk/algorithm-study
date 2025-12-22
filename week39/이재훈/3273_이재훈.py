n = int(input())
seq = sorted(map(int, input().split()))
x = int(input())

cnt = 0
left, right = 0, n - 1

while left < right:
  val = seq[left] + seq[right]

  if val == x:
    cnt += 1
    left += 1
    right -= 1
  elif val < x:
    left += 1
  else:
    right -= 1

print(cnt)
