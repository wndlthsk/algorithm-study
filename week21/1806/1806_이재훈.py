N, S = map(int, input().split())
seq = list(map(int, input().split()))

left, right = 0, 0
current_sum = 0
min_length = N + 1  # 가능한 최대 길이보다 크게 설정

while True:
  if current_sum >= S:
    min_length = min(min_length, right - left)
    current_sum -= seq[left]
    left += 1
  elif right == N:
    break
  else:
    current_sum += seq[right]
    right += 1
print(min_length if min_length != N + 1 else 0)