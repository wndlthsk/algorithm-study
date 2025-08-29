N, M = map(int, input().split())
Ai = list(map(int, input().split()))

left, right = 0, 0
sum_val = 0
cnt = 0
while True:
  if sum_val >= M:
    if sum_val == M:
      cnt += 1
    sum_val -= Ai[left]
    left += 1
  elif right == N: # right == N이 되었는데 sum_val값이 충분히 크다면, left가 계속 증가하며 M이 되는지 앞선 if문에서 체크함. (따라서 right == N만으로 종료조건이 됨.)
    break
  elif sum_val < M:
    sum_val += Ai[right]
    right += 1
print(cnt)