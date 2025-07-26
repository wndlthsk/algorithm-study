N, M = map(int, input().split())
seq = list(map(int, input().split()))

cnt = 0
left, right = 0, 0
cur_sum = 0
while True:
  if cur_sum >= M:
    cur_sum -= seq[left]
    left += 1
  elif right == N:
    break
  else:
    cur_sum += seq[right]
    right += 1

  if cur_sum == M:
    cnt += 1
print(cnt)