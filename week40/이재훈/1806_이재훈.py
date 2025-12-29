N, S = map(int, input().split())
seq = list(map(int, input().split()))

left, right = 0, 0
current_sum = 0
l = float('inf')

while True:
  if current_sum >= S:
    l = min(l, right - left)
    current_sum -= seq[left]
    left += 1
  else:
    if right == N:
      break
    current_sum += seq[right]
    right += 1

if l != float('inf'):
  print(l)
else:
  print(0)
