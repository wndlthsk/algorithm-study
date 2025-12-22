N = int(input())
seq = sorted(map(int, input().split()))

least = float('inf')
res = []

left, right = 0, N - 1
while left < right:
  val = seq[left] + seq[right]

  if abs(val) < least:
    least = abs(val)
    res = [seq[left], seq[right]]

  if val < 0:
    left += 1
  else:
    right -= 1
print(*res)